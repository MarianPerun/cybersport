package com.example.demo.Controller;


import com.example.demo.Model.Dota2Player;
import com.example.demo.Repository.Dota2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cybersport/api/dota2/")
public class Dota2Controller {
    @Autowired
    private Dota2Repository dota2Repository;

    @PostMapping("/add")
    @ResponseBody
    public Dota2Player add(@RequestBody Dota2Player myModel){
        dota2Repository.save(myModel);
        return myModel;
    }

    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<Dota2Player> viewAll(){
        return dota2Repository.findAll();
    }

    @GetMapping("view/{id}")
    @ResponseBody
    public Dota2Player viewId(@PathVariable Integer id){
        Optional<Dota2Player> OPT = dota2Repository.findById(id);
        return OPT.get();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteID(@PathVariable Integer id){
        dota2Repository.deleteById(id);
        return "{ Response : Deleted }";
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public Dota2Player updateId(@RequestBody Dota2Player dota2Player, @PathVariable Integer id){
        if(dota2Repository.findById(id).isPresent()){
            Dota2Player existingDota2Player = dota2Repository.findById(id).get();
            existingDota2Player.setNickname(dota2Player.getNickname());
            existingDota2Player.setMmr(dota2Player.getMmr());
            existingDota2Player.setRank(dota2Player.getRank());
            existingDota2Player.setRole(dota2Player.getRole());
            existingDota2Player.setSignature(dota2Player.getSignature());
            existingDota2Player.setSalary(dota2Player.getSalary());
            existingDota2Player.setWinrate(dota2Player.getWinrate());
            existingDota2Player.setTeam(dota2Player.getTeam());

            Dota2Player updatedDota2Player = dota2Repository.save(existingDota2Player);
            return new Dota2Player(updatedDota2Player.getNickname(),updatedDota2Player.getTeam(),updatedDota2Player.getSalary(),
                    updatedDota2Player.getWinrate(), updatedDota2Player.getRank(), updatedDota2Player.getMmr(),
                    updatedDota2Player.getSignature(), updatedDota2Player.getRole());
        }
        else{
            return null;
        }
        // ...
    }
}

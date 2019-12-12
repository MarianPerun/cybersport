package com.example.demo.Controller;

import com.example.demo.Model.CSGOPlayer;
import com.example.demo.Model.Dota2Player;
import com.example.demo.Repository.CSGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cybersport/api/csgo/")
public class CSGOController {
    @Autowired
    private CSGORepository csgoRepository;
    @PostMapping("/add")
    @ResponseBody
    public CSGOPlayer add(@RequestBody CSGOPlayer myModel){
        csgoRepository.save(myModel);
        return myModel;
    }

    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<CSGOPlayer> viewAll(){
        return csgoRepository.findAll();
    }

    @GetMapping("view/{id}")
    @ResponseBody
    public CSGOPlayer viewId(@PathVariable Integer id){
        Optional<CSGOPlayer> OPT = csgoRepository.findById(id);
        return OPT.get();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteID(@PathVariable Integer id){
        csgoRepository.deleteById(id);
        return "{ Response : Deleted }";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public CSGOPlayer updateId(@RequestBody CSGOPlayer dota2Player, @PathVariable Integer id){
        if(csgoRepository.findById(id).isPresent()){
            CSGOPlayer existingCSGOPlayer = csgoRepository.findById(id).get();
            existingCSGOPlayer.setNickname(dota2Player.getNickname());
            existingCSGOPlayer.setRank(dota2Player.getRank());
            existingCSGOPlayer.setSalary(dota2Player.getSalary());
            existingCSGOPlayer.setWinrate(dota2Player.getWinrate());
            existingCSGOPlayer.setTeam(dota2Player.getTeam());

            CSGOPlayer updatedCSGOPlayer = csgoRepository.save(existingCSGOPlayer);
            return new CSGOPlayer(updatedCSGOPlayer.getNickname(),updatedCSGOPlayer.getTeam(),updatedCSGOPlayer.getSalary(),
                    updatedCSGOPlayer.getWinrate(), updatedCSGOPlayer.getRank());
        }
        else{
            return null;
        }
    }
}

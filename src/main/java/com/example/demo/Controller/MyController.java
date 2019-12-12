package com.example.demo.Controller;


import com.example.demo.Model.CyberSportsman;
import com.example.demo.Model.Dota2Player;
import com.example.demo.Repository.Dota2Repository;
import com.example.demo.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/cybersport/api")
public class MyController {

    @Autowired
    private MyRepository myRepository;

    @PostMapping("/add")
    @ResponseBody
    public CyberSportsman add(@RequestBody CyberSportsman myModel){
        myRepository.save(myModel);
        return myModel;
    }


    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<CyberSportsman> view(){
        return myRepository.findAll();
    }

    @GetMapping("view/{id}")
    @ResponseBody
    public CyberSportsman viewID(@PathVariable Integer id){
        Optional<CyberSportsman> OPT = myRepository.findById(id);
        return OPT.get();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteID(@PathVariable Integer id){
        myRepository.deleteById(id);
        return "{Response : Deleted }";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public CyberSportsman updateId(@RequestBody CyberSportsman cyberSportsman, @PathVariable Integer id){
        if(myRepository.findById(id).isPresent()) {
            CyberSportsman existingCyberSportsman = myRepository.findById(id).get();

            existingCyberSportsman.setNickname(cyberSportsman.getNickname());
            existingCyberSportsman.setSalary(cyberSportsman.getSalary());
            existingCyberSportsman.setTeam(cyberSportsman.getTeam());
            existingCyberSportsman.setWinrate(cyberSportsman.getWinrate());

            CyberSportsman updatedCyberSportsman = myRepository.save(existingCyberSportsman);
            return new CyberSportsman(updatedCyberSportsman.getNickname(), updatedCyberSportsman.getTeam(),
                    updatedCyberSportsman.getSalary(), updatedCyberSportsman.getWinrate());
        }
        else{
            return null;
        }
    }
}

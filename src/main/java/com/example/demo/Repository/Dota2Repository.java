package com.example.demo.Repository;

import com.example.demo.Model.Dota2Player;
import org.springframework.data.repository.CrudRepository;

public interface Dota2Repository extends CrudRepository<Dota2Player, Integer> {
}

package com.example.demo.Repository;

import com.example.demo.Model.CSGOPlayer;
import org.springframework.data.repository.CrudRepository;

public interface CSGORepository extends CrudRepository<CSGOPlayer,Integer> {
}

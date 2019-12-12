package com.example.demo.Repository;

import com.example.demo.Model.CyberSportsman;
import org.springframework.data.repository.CrudRepository;

public interface MyRepository extends CrudRepository<CyberSportsman,Integer> {
}

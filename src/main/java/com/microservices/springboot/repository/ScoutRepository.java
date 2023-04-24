package com.microservices.springboot.repository;

import com.microservices.springboot.entity.Scout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoutRepository extends JpaRepository<Scout, Integer> {

    public Optional<Scout> findByFirstName(String firstName);
}

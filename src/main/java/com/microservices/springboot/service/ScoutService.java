package com.microservices.springboot.service;

import com.microservices.springboot.dto.ScoutDto;
import com.microservices.springboot.entity.Scout;

import java.util.List;
import java.util.Optional;

public interface ScoutService {
    ScoutDto createScout(ScoutDto scoutDto);

    ScoutDto getScout(int id);

    List<ScoutDto> getScouts();

    ScoutDto updateScout(int id, ScoutDto scoutDto);

    void deleteScout(int id);
}

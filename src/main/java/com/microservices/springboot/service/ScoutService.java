package com.microservices.springboot.service;

import com.microservices.springboot.dto.ScoutDto;

import java.util.List;

public interface ScoutService {
    ScoutDto createScout(ScoutDto scoutDto);

    ScoutDto getScout(int id);

    List<ScoutDto> getScouts();

    ScoutDto updateScout(int id, ScoutDto scoutDto);

    void deleteScout(int id);
}

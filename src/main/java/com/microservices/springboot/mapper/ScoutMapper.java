package com.microservices.springboot.mapper;

import com.microservices.springboot.dto.ScoutDto;
import com.microservices.springboot.entity.Scout;

public class ScoutMapper {

    public static ScoutDto scoutToScoutDto(Scout scout){

        return new ScoutDto(
            scout.getId(),
            scout.getFirstName(),
            scout.getLastName()
        );
    }

    public static Scout scoutDtoToScout(ScoutDto scoutDto){

        return new Scout(
                scoutDto.getId(),
                scoutDto.getFirstName(),
                scoutDto.getLastName()
        );
    }
}

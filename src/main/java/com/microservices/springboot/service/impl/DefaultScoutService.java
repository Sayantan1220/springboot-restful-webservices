package com.microservices.springboot.service.impl;

import com.microservices.springboot.dto.ScoutDto;
import com.microservices.springboot.entity.Scout;
import com.microservices.springboot.mapper.ScoutMapper;
import com.microservices.springboot.repository.ScoutRepository;
import com.microservices.springboot.service.ScoutService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultScoutService implements ScoutService {

    private ScoutRepository scoutRepository;

    private ModelMapper modelMapper;

    @Override
    public ScoutDto createScout(ScoutDto scoutDto) {
        //Scout scout = ScoutMapper.scoutDtoToScout(scoutDto);
        Scout scout = modelMapper.map(scoutDto, Scout.class);
        Scout createdScout = scoutRepository.save(scout);
        //return ScoutMapper.scoutToScoutDto(createdScout);
        return modelMapper.map(scout, ScoutDto.class);
    }

    @Override
    public ScoutDto getScout(int id) {
        Optional<Scout> scout = scoutRepository.findById(id);
        //return ScoutMapper.scoutToScoutDto(scout.get());
        return modelMapper.map(scout.get(), ScoutDto.class);
    }

    @Override
    public List<ScoutDto> getScouts() {
        List<Scout> scoutList = scoutRepository.findAll();
        List<ScoutDto> scoutDtoList = new ArrayList<>();
        for (Scout scout : scoutList){
            //scoutDtoList.add(ScoutMapper.scoutToScoutDto(scout));
            scoutDtoList.add(modelMapper.map(scout, ScoutDto.class));
        }
        return scoutDtoList;
    }

    @Override
    public ScoutDto updateScout(int id, ScoutDto scoutDto) {
        Optional<Scout> scoutPresent = scoutRepository.findById(id);
        if (scoutPresent.isPresent()){
            Scout scoutToUpdate = scoutPresent.get();
            scoutToUpdate.setFirstName(scoutDto.getFirstName());
            scoutToUpdate.setLastName(scoutDto.getLastName());
            scoutRepository.save(scoutToUpdate);
            //return ScoutMapper.scoutToScoutDto(scoutToUpdate);
            return modelMapper.map(scoutToUpdate, ScoutDto.class);
        }
        return null;
    }

    @Override
    public void deleteScout(int id) {
        scoutRepository.deleteById(id);
    }
}

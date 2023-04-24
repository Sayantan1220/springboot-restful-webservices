package com.microservices.springboot.controller;

import com.microservices.springboot.dto.ScoutDto;
import com.microservices.springboot.service.ScoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs for Scouts",
        description = "Create, update, get, delete Scouts"
)
@RestController
@AllArgsConstructor
@RequestMapping("scouts")
public class ScoutController {

    private ScoutService scoutService;

    @Operation(
            summary = "Create Scout API",
            description = "REST API to create Scout"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http created"
    )
    @PostMapping("/createScout")
    public ResponseEntity<ScoutDto> createScout(@RequestBody ScoutDto scout){
        ScoutDto createdScout = scoutService.createScout(scout);
        return new ResponseEntity<>(createdScout, HttpStatus.CREATED);
    }

    @GetMapping("/getScoutById/{id}")
    public ResponseEntity<ScoutDto> getScoutById(@PathVariable int id){
        return new ResponseEntity<>(scoutService.getScout(id), HttpStatus.OK);
    }

    @GetMapping("/getAllScouts")
    public ResponseEntity<List<ScoutDto>> getAllScouts(){
        List<ScoutDto> scoutList = scoutService.getScouts();
        return new ResponseEntity<>(scoutList, HttpStatus.OK);
    }

    @PutMapping("/updateScout/{id}")
    public ResponseEntity<ScoutDto> updateScout(@PathVariable int id,
                                                @RequestBody ScoutDto scout){
        ScoutDto updatedScout = scoutService.updateScout(id, scout);
        return new ResponseEntity<>(updatedScout, HttpStatus.OK);
    }

    @DeleteMapping("/deleteScout/{id}")
    public ResponseEntity<String> deleteScout(@PathVariable int id){
        scoutService.deleteScout(id);
        return new ResponseEntity<>("Deleted Scout with id: " + id,HttpStatus.OK);
    }

}

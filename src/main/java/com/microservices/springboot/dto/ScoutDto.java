package com.microservices.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DTO class for Scout"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoutDto {

    private int id;
    private String firstName;
    private String lastName;

}

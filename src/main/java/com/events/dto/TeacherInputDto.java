package com.events.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherInputDto {
    @NotNull
    @NotBlank
    private String name; 
    
    @NotNull
    @NotBlank
    private String bio;
    
    private String avatar_url;
}

package com.example.dice_minigame.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamRequest {
    @NotBlank
    private String teamName;
    @NotBlank
    private String country;
    @NotNull
    private Integer memberCount;
}

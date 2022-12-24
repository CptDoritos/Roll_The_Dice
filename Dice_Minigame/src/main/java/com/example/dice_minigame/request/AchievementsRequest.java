package com.example.dice_minigame.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievementsRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private Boolean complete;
}

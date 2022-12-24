package com.example.dice_minigame.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest {
    @NotBlank
    private String userName;
    @NotNull
    private Integer victories;
    @NotNull
    private Integer losses;
    @NotNull
    private Integer points;

    private Boolean reported;
    @NotNull
    @Valid
    private AchievementsRequest achievements;

}

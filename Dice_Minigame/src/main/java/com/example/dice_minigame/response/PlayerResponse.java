package com.example.dice_minigame.response;

import com.example.dice_minigame.Entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {
    private long id;
    private String userName;
    private String teamName;
    private Integer victories;
    private Integer losses;
    private Integer points;
    private Boolean reported;

    private AchievementsResponse achievements;

    public PlayerResponse(Player player){
        id = player.getId();
        userName = player.getUserName();
        victories = player.getVictories();
        losses = player.getLosses();
        points = player.getPoints();
        reported = player.getReported();
        achievements = new AchievementsResponse(player.getAchievements());
    }
}

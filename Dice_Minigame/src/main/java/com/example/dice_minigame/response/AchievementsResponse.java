package com.example.dice_minigame.response;

import com.example.dice_minigame.Entity.Achievements;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievementsResponse {

private String title;
private String description;
private Boolean complete;

public AchievementsResponse(Achievements achievements)
    {
        title = achievements.getTitle();
        description = achievements.getDescription();
        complete = achievements.getComplete();
    }
}

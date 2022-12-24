package com.example.dice_minigame.response;

import com.example.dice_minigame.Entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

    private long id;
    private String teamName;
    private String country;
    private Integer memberCount;

    public TeamResponse(Team team)
    {
        id = team.getId();
        teamName = team.getTeamName();
        country = team.getCountry();
        memberCount = team.getMemberCount();
    }
}

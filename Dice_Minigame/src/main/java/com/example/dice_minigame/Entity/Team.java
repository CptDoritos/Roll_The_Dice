package com.example.dice_minigame.Entity;

import com.example.dice_minigame.request.TeamRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="teams")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="teamName", nullable = false)
    private String teamName;
    @Column(name="country", nullable = false)
    private String country;
    @Column(name="memberCount", nullable = false)
    private Integer memberCount;

    public Team(TeamRequest teamRequest){
        teamName = teamRequest.getTeamName();
        country = teamRequest.getCountry();
        memberCount = teamRequest.getMemberCount();
    }
}

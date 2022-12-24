package com.example.dice_minigame.Entity;

import com.example.dice_minigame.request.PlayerRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name="players")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_name", nullable = false, length=255)
    private String userName;
    @Column(name="victories", nullable = false)
    private Integer victories;
    @Column(name="losses", nullable = false)
    private Integer losses;
    @Column(name="points", nullable = false)
    private Integer points;
    @Column(name="reported")
    private Boolean reported;

    @ManyToOne(optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="teamId")
    private Team team;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Achievements achievements;

    public Player(PlayerRequest playerRequest){
        userName = playerRequest.getUserName();
        victories = playerRequest.getVictories();
        losses = playerRequest.getLosses();
        points = playerRequest.getPoints();
        reported = playerRequest.getReported();

        achievements = new Achievements(playerRequest.getAchievements());

    }
}

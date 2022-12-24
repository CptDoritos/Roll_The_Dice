package com.example.dice_minigame.Entity;

import com.example.dice_minigame.request.AchievementsRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="achievements")
public class Achievements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="complete")
    private Boolean complete;

    public Achievements(AchievementsRequest achievementsRequest){
        title = achievementsRequest.getTitle();
        description = achievementsRequest.getDescription();
        complete = achievementsRequest.getComplete();
    }

}

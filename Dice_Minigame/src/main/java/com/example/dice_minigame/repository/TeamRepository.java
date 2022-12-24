package com.example.dice_minigame.repository;

import com.example.dice_minigame.Entity.Achievements;
import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findAllByteamNameIgnoreCase(String teamName);

}

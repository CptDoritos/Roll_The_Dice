package com.example.dice_minigame.repository;

import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findAllByUserNameIgnoreCase(String userName);

    public List<Player> findAllByTeamId(long teamId);

    @Transactional
    void deleteAllByTeamId(long teamId);
}

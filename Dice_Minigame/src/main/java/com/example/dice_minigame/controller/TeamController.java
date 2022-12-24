package com.example.dice_minigame.controller;

import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import com.example.dice_minigame.request.PlayerRequest;
import com.example.dice_minigame.request.TeamRequest;
import com.example.dice_minigame.response.PlayerResponse;
import com.example.dice_minigame.response.TeamResponse;
import com.example.dice_minigame.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/{teamId}")
    public TeamResponse getTeams(@PathVariable long teamId){
        return new TeamResponse(teamService.getTeams(teamId));
    }

    @PutMapping("/{teamId}")
    public TeamResponse updateTeams(@PathVariable long teamId, @Valid @RequestBody TeamRequest teamRequest){
        return new TeamResponse(teamService.updateTeams(teamId, teamRequest));
    }

    @DeleteMapping("/{teamId}")
    public void deleteTeams(@PathVariable long teamId)
    {
        teamService.deleteTeam(teamId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponse addTeam(@Valid @RequestBody TeamRequest teamRequest)
    {

        Team savedTeam = teamService.addTeam(teamRequest);

        return new TeamResponse(savedTeam);

    }

    @GetMapping()
    public List<TeamResponse> getAllTeams(@RequestParam(required = false) String teamName){
        List<Team> teams = teamService.getAllTeams(teamName);

        List<TeamResponse> teamResponse = new ArrayList<>();
        teams.forEach(team -> {
            teamResponse.add(new TeamResponse(team));
        });
        return teamResponse;
    }
}

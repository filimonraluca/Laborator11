package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/games")
public class GameResource {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/all")
    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    @PostMapping("/load")
    public List<Game> persist(@RequestBody final Game game){
        gameRepository.save(game);
        return gameRepository.findAll();
    }
}

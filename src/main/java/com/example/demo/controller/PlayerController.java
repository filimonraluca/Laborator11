package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Am folosit @RequestMapping pentru a mapa path-ul /rest/players cu clasa PlayerController.
 */
@RestController
@RequestMapping("/rest/players")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    /**
     * Am folosit get mapping pentru a mapa path-ul /all cu metoda getAll(). Functia findAll() din interiorul metodei este
     * apelate metoda finAll() oferita de JpaRepository. FindAll() returneaza o lista cu toti jucatorii din baza de date.
     * @return List<Player> lista de jucatori din baza de date
     */
    @GetMapping("/all")
    public List<Player> getAll(){
        return playerRepository.findAll();
    }
}

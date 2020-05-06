package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Am folosit @RequestMapping pentru a mapa path-ul /rest/players cu clasa PlayerController.
 */
@RestController
@RequestMapping("/rest/players")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    /**
     * Am folosit GetMapping pentru a mapa path-ul /all cu metoda getAll(). Metoda findAll() apelata in interiorul metodei curente
     * este oferita de JpaRepository. FindAll() returneaza o lista cu toti jucatorii din baza de date.
     * @return List<Player> lista de jucatori din baza de date
     */
    @GetMapping("/all")
    public List<Player> getAll(){
        return playerRepository.findAll();
    }


    /**
     * Am folosit PostMapping pentru a mapa path-ul /add cu metoda getAll(). Metodele findAll() si save()
     * apelata in interiorul metodei curente sunt oferite de JpaRepository.
     * FindAll() returneaza o lista cu toti jucatorii din baza de date.
     * save() salveaza entitatea in baza de date.
     * @return List<Player> lista de jucatori din baza de date
     */
    @PostMapping("/add")
    public List<Player> savePlayer(@RequestBody final Player player){
        playerRepository.save(player);
        return playerRepository.findAll();
    }


    /**
     * Am folosit PutMapping pentru a mapa path-ul /update/{id} cu metoda updatePlayer().
     * Am folosit metoda findById() pentru a afla jucatorul din baza de date cu id-ul dat ca paramentru.
     * Aceasta metoda returneaza un obiect de tipul Optional<T> care poate sau nu avea o valoare in el.
     * Metoda isPresent returneaza true daca exista o valoare in obiect si false altfel. In cazul in care
     * am gasit un jucator cu id-ul dat folosim metoda get() pentru a prelua valoarea din obiect si ii schimbam
     * numele cu cel din body-ul requestului dupa care il salvam.
     * @return List<Player> lista de jucatori din baza de date
     */
    @PutMapping("/update/{id}")
    public List<Player> updatePlayer(@PathVariable int id, @RequestBody Map<String, String> body){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            player.get().setName(body.get("name"));
            playerRepository.save(player.get());
        }
        return playerRepository.findAll();
    }

    /**
     * Am folosit metoda deteleMapping pantru a mapa path-ul delete/{id} cu metoda deletePlayer.
     * Am folosit metoda findById pentru a gasi jucatorul cu id-ul dat ca paramentru. Aceasta metoda
     * returneaza un obiect de tipul Optional<T> care poate sau nu avea valori in interiorul sau.
     * Folosim metoda isPresent pentru a verifica daca obiectul are valori sau nu. In cazul in care
     * are am gasit un jucator cu id-ul dat il stergem din baza de date folosind metoda delete()
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public List<Player> deletePlayer(@PathVariable int id){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            playerRepository.delete(player.get());
        }
        return playerRepository.findAll();
    }

}

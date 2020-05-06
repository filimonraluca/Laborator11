package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Am creat interfata PlayerRepository care extinde JpaRepository. JpaRepository ofera niste functionalitati
 * precum salvare, stergere, preluarea de informatii. Notatia @Repository anunta Spring ca aceasta clasa este un repository.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}

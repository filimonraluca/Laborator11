package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clasa Player este o entitate reprezentand tabela cu acelasi nume din baza de date. Coloana id este primary key si auto generata.
 * Pentru a anunta Spring ca aceasta este primary key folosim @id si @GeneratedValue(strategy = GenerationType.AUTO) pentru a
 * anunta ca este autogenerata deci nu va fi oferita de catre un unser.
 */

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

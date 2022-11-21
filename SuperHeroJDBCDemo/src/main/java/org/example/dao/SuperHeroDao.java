package org.example.dao;

import org.example.model.Superhero;

import java.util.List;

public interface SuperHeroDao {
    //CRUD
    Superhero save(Superhero superhero);

    Superhero readById(int id);

    List<Superhero> readAll();

    Superhero update(Superhero superhero);

    boolean deleteById(int id);


}

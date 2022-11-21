package org.example.dao;

import org.example.model.Superhero;

import java.util.List;

public class SuperHeroDaoDummyImpl implements SuperHeroDao{

    //NOT ACTUALLY CONNECTED TO DATABASE
    @Override
    public Superhero save(Superhero superhero) {
        //simulate the autoincrement with some arbitrary id value
        superhero.setId(45);
        return superhero;
    }

    @Override
    public Superhero readById(int id) {
        return null;
    }

    @Override
    public List<Superhero> readAll() {
        return null;
    }

    @Override
    public Superhero update(Superhero superhero) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}

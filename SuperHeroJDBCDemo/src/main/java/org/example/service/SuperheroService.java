package org.example.service;

import org.example.dao.SuperHeroDao;

import org.example.model.Superhero;
import org.example.util.DaoFactory;

public class SuperheroService {

    private SuperHeroDao superHeroDao;

    public SuperheroService(){
        //do the creation of the dao
        this.superHeroDao = DaoFactory.getSuperHeroDao();
    }

    public Superhero save(Superhero superhero){
        //invoking the methods from the DAO;
        //we need an instance of the DAO implementation class:
        return this.superHeroDao.save(superhero);
    }
}

package org.example;

import org.example.dao.SuperHeroDao;
import org.example.dao.SuperHeroDaoImpl;
import org.example.model.Superhero;
import org.example.service.SuperheroService;

public class App {
    public static void main( String[] args ) {
        //SAVE
        //Use -1 as a placeholder for id
        Superhero superhero = new Superhero(-1, "RainMan", "Flying", 20, "Kryptonite", "D","Krypton");
        SuperHeroDao superHeroDao = new SuperHeroDaoImpl();
        superHeroDao.save(superhero);

        //READ
        //SuperHeroDao superHeroDao =  new SuperHeroDaoImpl();
        superHeroDao.readById(1);

        //READ ALL
        //SuperHeroDao superHeroDao =  new SuperHeroDaoImpl();
        superHeroDao.readAll();

        //UPDATE TEST
        Superhero superWoman = new Superhero(7, "Superwoman", "Flying", 20, "Kryptonite", "D","Krypton");
        //SuperHeroDao superHeroDao = new SuperHeroDaoImpl();
        superHeroDao.update(superWoman);

        //DELETE
        //SuperHeroDao superHeroDao =  new SuperHeroDaoImpl();
        superHeroDao.deleteById(14);

        //FACTORY
        SuperheroService superheroService = new SuperheroService();
        superheroService.save(superhero);
    }

    //https://github.com/roryeiffe/superheroes-11-17-2022
}

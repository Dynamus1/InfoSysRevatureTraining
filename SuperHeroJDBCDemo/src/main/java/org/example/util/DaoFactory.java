package org.example.util;

import org.example.dao.SuperHeroDao;
import org.example.dao.SuperHeroDaoDummyImpl;
import org.example.dao.SuperHeroDaoImpl;


public class DaoFactory {

    //set up/declare our superHeroDao
    private static SuperHeroDao superHeroDao = null;

    private static SuperHeroDao superHeroDaoDummy = null;

    //Make different methods to return different types of daos:
    public static SuperHeroDao getSuperHeroDao(){
        if(superHeroDao == null) {
            superHeroDao = new SuperHeroDaoImpl();
            return superHeroDao;
        }

        return null;
    }

    public static SuperHeroDao getSuperHeroDaoDummy(){
        if(superHeroDaoDummy == null) {
            superHeroDaoDummy = new SuperHeroDaoDummyImpl();
            return superHeroDaoDummy;
        }

        return null;
    }
}

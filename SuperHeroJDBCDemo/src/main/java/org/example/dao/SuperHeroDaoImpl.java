package org.example.dao;

import org.example.model.Superhero;
import org.example.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        //Use prepared statement to prevent SQL injection
        String sql = "INSERT INTO superhero VALUES(DEFAULT, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3,superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            //this will actually execute the statement
            int count = preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            //if count is 1, that means success. We have updated the table
            if(count == 1) {
                System.out.println("Created superhero's id is "+rs.getInt(1));
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Superhero readById(int id) {
        String sql = "SELECT * FROM superhero WHERE id = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            Superhero superhero = new Superhero();

            while(rs.next()){
                superhero.setId(rs.getInt("id"));
                superhero.setSuperhero_name(rs.getString("superhero_name"));
                superhero.setSuper_power(rs.getString("super_power"));
                superhero.setStrength(rs.getInt("strength"));
                superhero.setWeakness(rs.getString("weakness"));
                superhero.setFranchise(rs.getString("franchise"));
                superhero.setWorld(rs.getString("world"));
            }

            System.out.println("Superhero id is "+ superhero.getId());
            System.out.println("Superhero name is "+ superhero.getSuperhero_name());
            System.out.println("Superhero super power is "+ superhero.getSuper_power());
            System.out.println("Superhero strength is "+ superhero.getStrength());
            System.out.println("Superhero weakness is "+ superhero.getWeakness());
            System.out.println("Superhero franchise is "+ superhero.getFranchise());
            System.out.println("Superhero world is "+superhero.getWorld());

            return superhero;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Superhero> readAll() {

        String sql = "SELECT * FROM superhero;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Superhero> superheroes = new ArrayList<>();

            while(rs.next()){
                Superhero superhero = new Superhero();
                superhero.setId(rs.getInt("id"));
                superhero.setSuperhero_name(rs.getString("superhero_name"));
                superhero.setSuper_power(rs.getString("super_power"));
                superhero.setStrength(rs.getInt("strength"));
                superhero.setWeakness(rs.getString("weakness"));
                superhero.setFranchise(rs.getString("franchise"));
                superhero.setWorld(rs.getString("world"));
                superheroes.add(superhero);
            }

            System.out.println("Superheroes table size is "+superheroes.size());

            for(int i = 0; i < superheroes.size();i++){
                System.out.println("Superhero id is "+ superheroes.get(i).getId());
                System.out.println("Superhero name is "+ superheroes.get(i).getSuperhero_name());
                System.out.println("Superhero super power is "+ superheroes.get(i).getSuper_power());
                System.out.println("Superhero strength is "+ superheroes.get(i).getStrength());
                System.out.println("Superhero weakness is "+ superheroes.get(i).getWeakness());
                System.out.println("Superhero franchise is "+ superheroes.get(i).getFranchise());
                System.out.println("Superhero world is "+superheroes.get(i).getWorld());
            }
            return superheroes;


        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Superhero update(Superhero superhero) {

        String sql = "UPDATE superhero SET superhero_name = ?,super_power = ?, strength = ?, weakness = ?, franchise = ?, world =?  WHERE id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3,superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());
            preparedStatement.setInt(7, superhero.getId());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while(rs.next()){
                superhero.setSuperhero_name(rs.getString("superhero_name"));
                superhero.setSuper_power(rs.getString("super_power"));
                superhero.setStrength(rs.getInt("strength"));
                superhero.setWeakness(rs.getString("weakness"));
                superhero.setFranchise(rs.getString("franchise"));
                superhero.setWorld(rs.getString("world"));
            }
            return superhero;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM superhero WHERE id = ?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            return preparedStatement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

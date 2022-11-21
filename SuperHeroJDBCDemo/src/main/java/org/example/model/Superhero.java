package org.example.model;

public class Superhero {
    private int id;
    private String superhero_name;
    private String super_power;
    private int strength;
    private String weakness;
    private String franchise;
    private String world;

    public Superhero(){}
    public Superhero(int id, String superhero_name, String super_power, int strength, String weakness, String franchise, String world) {
        this.id = id;
        this.superhero_name = superhero_name;
        this.super_power = super_power;
        this.strength = strength;
        this.weakness = weakness;
        this.franchise = franchise;
        this.world = world;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuperhero_name() {
        return superhero_name;
    }

    public void setSuperhero_name(String superhero_name) {
        this.superhero_name = superhero_name;
    }

    public String getSuper_power() {
        return super_power;
    }

    public void setSuper_power(String super_power) {
        this.super_power = super_power;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + id +
                ", superhero_name='" + superhero_name + '\'' +
                ", super_power='" + super_power + '\'' +
                ", strength=" + strength +
                ", weakness='" + weakness + '\'' +
                ", franchise=" + franchise +
                ", world='" + world + '\'' +
                '}';
    }
}

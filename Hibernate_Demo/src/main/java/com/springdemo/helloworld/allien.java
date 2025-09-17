package com.springdemo.helloworld;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="alien_data")//every should have primary key handle to hidernate// alien if want change table
public class allien {

    @Id
    @Column(name="a-id")//change attritube
    private int id;
    @Column(name="a-name")
    private String name;
    private String tech;

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
    public String getTech() {
        return tech;
    }
    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "allien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}

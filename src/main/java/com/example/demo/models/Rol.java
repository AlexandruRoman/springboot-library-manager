package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by Alex on 12/27/2017.
 */
@Entity
@Table(name = "roluri")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private String nume;

    public Rol() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

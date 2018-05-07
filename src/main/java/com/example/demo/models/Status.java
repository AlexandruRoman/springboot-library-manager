package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by Alex on 12/27/2017.
 */
@Entity
@Table(name = "statusuri")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String nume;

    public Status() {}

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

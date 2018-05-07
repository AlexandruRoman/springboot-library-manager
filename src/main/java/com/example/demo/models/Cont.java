package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by Alex on 12/27/2017.
 */
@Entity
@Table(name = "conturi")
public class Cont {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String nume;

    @Column(nullable = false)
    private String parola;

    @Column(name = "id_status", nullable = false)
    private short idStatus;

    @Column(name = "id_rol", nullable = false)
    private short idRol;

    public Cont() {}

    public Cont(String nume, String parola, short idStatus, short idRol) {
        this.nume = nume;
        this.parola = parola;
        this.idStatus = idStatus;
        this.idRol = idRol;
    }

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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public short getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(short idStatus) {
        this.idStatus = idStatus;
    }

    public short getIdRol() {
        return idRol;
    }

    public void setIdRol(short idRol) {
        this.idRol = idRol;
    }
}

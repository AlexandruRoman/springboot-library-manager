package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by Alex on 12/27/2017.
 */
@Entity
@Table(name = "cuvinte")
public class Cuvant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String nume;

    @Column(nullable = false)
    private String explicatie;

    @Column(name = "numar_accesari", nullable = false)
    private long numarAccesari;

    @Column(name = "id_categorie", nullable = false)
    private long idCategorie;

    public Cuvant(){}

    public Cuvant(String nume, String explicatie, long idCategorie) {
        this.nume = nume;
        this.explicatie = explicatie;
        this.idCategorie = idCategorie;
        this.numarAccesari = 0;
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

    public String getExplicatie() {
        return explicatie;
    }

    public void setExplicatie(String explicatie) {
        this.explicatie = explicatie;
    }

    public long getNumarAccesari() {
        return numarAccesari;
    }

    public void setNumarAccesari(long numarAccesari) {
        this.numarAccesari = numarAccesari;
    }

    public long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }
}

package com.example.demo.models;

import javax.persistence.*;

/**
 * Created by Alex on 12/28/2017.
 */
@Entity
@Table(name = "cautari")
public class Cautare
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_cont", nullable = false)
    private long idCont;

    @Column(name = "id_cuvant", nullable = false)
    private long idCuvant;

    @Column(name = "numar_accesari", nullable = false)
    private long numarAccesari;

    public Cautare() {}

    public Cautare(long idCont, long idCuvant) {
        this.idCont = idCont;
        this.idCuvant = idCuvant;
        this.numarAccesari = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCont() {
        return idCont;
    }

    public void setIdCont(long idCont) {
        this.idCont = idCont;
    }

    public long getIdCuvant() {
        return idCuvant;
    }

    public void setIdCuvant(long idCuvant) {
        this.idCuvant = idCuvant;
    }

    public long getNumarAccesari() {
        return numarAccesari;
    }

    public void setNumarAccesari(long numarAccesari) {
        this.numarAccesari = numarAccesari;
    }
}

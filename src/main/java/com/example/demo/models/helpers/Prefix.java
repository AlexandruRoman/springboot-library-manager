package com.example.demo.models.helpers;

/**
 * Created by Alex on 12/28/2017.
 */
public class Prefix {
    private String prefix;
    private long idCont;

    public Prefix() {
    }

    public Prefix(String prefix, long idCont) {
        this.prefix = prefix;
        this.idCont = idCont;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public long getIdCont() {
        return idCont;
    }

    public void setIdCont(long idCont) {
        this.idCont = idCont;
    }
}

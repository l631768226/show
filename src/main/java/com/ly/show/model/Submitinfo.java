package com.ly.show.model;

public class Submitinfo {
    private Integer id;

    private String gutmicrobiota;

    private String metabolite;

    private String gene;

    private String referencepmid;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGutmicrobiota() {
        return gutmicrobiota;
    }

    public void setGutmicrobiota(String gutmicrobiota) {
        this.gutmicrobiota = gutmicrobiota == null ? null : gutmicrobiota.trim();
    }

    public String getMetabolite() {
        return metabolite;
    }

    public void setMetabolite(String metabolite) {
        this.metabolite = metabolite == null ? null : metabolite.trim();
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene == null ? null : gene.trim();
    }

    public String getReferencepmid() {
        return referencepmid;
    }

    public void setReferencepmid(String referencepmid) {
        this.referencepmid = referencepmid == null ? null : referencepmid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}
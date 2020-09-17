package com.ly.show.model;

public class QListDetailRst {

    private Integer id;

    private Integer indexId;

    private String associationType;
    private String disorder;
    private String intervention;
    private String classification;
    private String sequencing;




    private String humanMouse;

    private String gutMicrobiota;

    private String strain;

    private String metabolite;

    private String gene;

    private String alteration;

    private String pmid;

    public Integer getId() {
        return id;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getMetabolite() {
        return metabolite;
    }

    public void setMetabolite(String metabolite) {
        this.metabolite = metabolite;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getAssociationType() {
        return associationType;
    }

    public void setAssociationType(String associationType) {
        this.associationType = associationType;
    }

    public String getHumanMouse() {
        return humanMouse;
    }

    public void setHumanMouse(String humanMouse) {
        this.humanMouse = humanMouse;
    }

    public String getDisorder() {
        return disorder;
    }

    public void setDisorder(String disorder) {
        this.disorder = disorder;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public String getGutMicrobiota() {
        return gutMicrobiota;
    }

    public void setGutMicrobiota(String gutMicrobiota) {
        this.gutMicrobiota = gutMicrobiota;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getAlteration() {
        return alteration;
    }

    public void setAlteration(String alteration) {
        this.alteration = alteration;
    }

    public String getSequencing() {
        return sequencing;
    }

    public void setSequencing(String sequencing) {
        this.sequencing = sequencing;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }
}

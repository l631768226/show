package com.ly.show.model;

public class Association {
    private Integer id;

    private Integer index;

    private String pmid;

    private String gutmicrobiota;

    private String gutmicrobiatancbiid;

    private String gutmicrobiotaid;

    private String classification;

    private String strain;

    private String sampletype;

    private String substrate;

    private String substratepubchemcid;

    private String metabolite;

    private String metabolitepubchemcid;

    private String gene;

    private String geneid;

    private String alteration;

    private String description;

    private String humanMouse;

    private String experiment;

    private String platform;

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getGutmicrobiota() {
        return gutmicrobiota;
    }

    public void setGutmicrobiota(String gutmicrobiota) {
        this.gutmicrobiota = gutmicrobiota == null ? null : gutmicrobiota.trim();
    }

    public String getGutmicrobiatancbiid() {
        return gutmicrobiatancbiid;
    }

    public void setGutmicrobiatancbiid(String gutmicrobiatancbiid) {
        this.gutmicrobiatancbiid = gutmicrobiatancbiid == null ? null : gutmicrobiatancbiid.trim();
    }

    public String getGutmicrobiotaid() {
        return gutmicrobiotaid;
    }

    public void setGutmicrobiotaid(String gutmicrobiotaid) {
        this.gutmicrobiotaid = gutmicrobiotaid == null ? null : gutmicrobiotaid.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain == null ? null : strain.trim();
    }

    public String getSampletype() {
        return sampletype;
    }

    public void setSampletype(String sampletype) {
        this.sampletype = sampletype == null ? null : sampletype.trim();
    }

    public String getSubstrate() {
        return substrate;
    }

    public void setSubstrate(String substrate) {
        this.substrate = substrate == null ? null : substrate.trim();
    }

    public String getSubstratepubchemcid() {
        return substratepubchemcid;
    }

    public void setSubstratepubchemcid(String substratepubchemcid) {
        this.substratepubchemcid = substratepubchemcid == null ? null : substratepubchemcid.trim();
    }

    public String getMetabolite() {
        return metabolite;
    }

    public void setMetabolite(String metabolite) {
        this.metabolite = metabolite == null ? null : metabolite.trim();
    }

    public String getMetabolitepubchemcid() {
        return metabolitepubchemcid;
    }

    public void setMetabolitepubchemcid(String metabolitepubchemcid) {
        this.metabolitepubchemcid = metabolitepubchemcid == null ? null : metabolitepubchemcid.trim();
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene == null ? null : gene.trim();
    }

    public String getGeneid() {
        return geneid;
    }

    public void setGeneid(String geneid) {
        this.geneid = geneid == null ? null : geneid.trim();
    }

    public String getAlteration() {
        return alteration;
    }

    public void setAlteration(String alteration) {
        this.alteration = alteration == null ? null : alteration.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getHumanMouse() {
        return humanMouse;
    }

    public void setHumanMouse(String humanMouse) {
        this.humanMouse = humanMouse == null ? null : humanMouse.trim();
    }

    public String getExperiment() {
        return experiment;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment == null ? null : experiment.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }
}
package com.ly.show.model;

public class QSearchRec {

    private Integer type;

    private String gutMicrobiota;

    private String metabolite;

    private String gene;

    private Integer page;

    private Integer pageSize;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGutMicrobiota() {
        return gutMicrobiota;
    }

    public void setGutMicrobiota(String gutMicrobiota) {
        this.gutMicrobiota = gutMicrobiota;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

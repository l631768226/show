package com.ly.show.model;

import java.util.List;

public class QFirstRst {

    private String id;

    private String label;

    private List<QSecondRst> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<QSecondRst> getChildren() {
        return children;
    }

    public void setChildren(List<QSecondRst> children) {
        this.children = children;
    }
}

package com.ly.show.model;

import java.util.List;

public class QSecondRst {

    private String id;

    private String label;

    private List<QThirdRst> children;

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

    public List<QThirdRst> getChildren() {
        return children;
    }

    public void setChildren(List<QThirdRst> children) {
        this.children = children;
    }
}

package org.media.model;

/**
 * Created by shantonu on 2/4/17.
 */
public class Label {
    private Integer ID;
    private String NAME;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Label(){}
    public Label(Integer ID, String NAME) {
        this.ID = ID;
        this.NAME = NAME;
    }
}

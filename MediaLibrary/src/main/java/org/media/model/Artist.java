package org.media.model;

/**
 * Created by shantonu on 1/31/17.
 */
public class Artist {
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

    public Artist(){}
    public Artist(Integer ID, String NAME) {
        this.ID = ID;
        this.NAME = NAME;
    }

    @Override
    public boolean equals(Object o) {
        Artist artist = (Artist) o;
        if (!getID().equals(artist.getID())) return false;
        return getNAME().equals(artist.getNAME());
    }

}

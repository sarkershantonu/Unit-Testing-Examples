package org.media.model;



/**
 * Created by shantonu on 2/4/17.
 */
public class Track {
    private Integer ID;
    private String TITLE;
    private String DURATION;
    private Integer GENRE_ID;
    private Integer ARTIST_ID;
    private Integer RECORDING_ID;
    public Track(){}
    public Track(Integer ID, String TITLE, String DURATION, Integer GENRE_ID, Integer ARTIST_ID, Integer RECORDING_ID) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.DURATION = DURATION;
        this.GENRE_ID = GENRE_ID;
        this.ARTIST_ID = ARTIST_ID;
        this.RECORDING_ID = RECORDING_ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public Integer getGENRE_ID() {
        return GENRE_ID;
    }

    public void setGENRE_ID(Integer GENRE_ID) {
        this.GENRE_ID = GENRE_ID;
    }

    public Integer getARTIST_ID() {
        return ARTIST_ID;
    }

    public void setARTIST_ID(Integer ARTIST_ID) {
        this.ARTIST_ID = ARTIST_ID;
    }

    public Integer getRECORDING_ID() {
        return RECORDING_ID;
    }

    public void setRECORDING_ID(Integer RECORDING_ID) {
        this.RECORDING_ID = RECORDING_ID;
    }
}

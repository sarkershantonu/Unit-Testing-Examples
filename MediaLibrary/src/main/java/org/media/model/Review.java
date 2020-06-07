package org.media.model;

/**
 * Created by shantonu on 2/4/17.
 */
public class Review {
    private Integer ID;
    private Integer REVIEWER_ID;
    private Integer RECORDING_ID;
    private Integer RATING;
    private String REVIEW;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getREVIEWER_ID() {
        return REVIEWER_ID;
    }

    public void setREVIEWER_ID(Integer REVIEWER_ID) {
        this.REVIEWER_ID = REVIEWER_ID;
    }

    public Integer getRECORDING_ID() {
        return RECORDING_ID;
    }

    public void setRECORDING_ID(Integer RECORDING_ID) {
        this.RECORDING_ID = RECORDING_ID;
    }

    public Integer getRATING() {
        return RATING;
    }

    public void setRATING(Integer RATING) {
        this.RATING = RATING;
    }

    public String getREVIEW() {
        return REVIEW;
    }

    public void setREVIEW(String REVIEW) {
        this.REVIEW = REVIEW;
    }
    public Review(){}
    public Review(Integer ID, Integer REVIEWER_ID, Integer RECORDING_ID, Integer RATING, String REVIEW) {
        this.ID = ID;
        this.REVIEWER_ID = REVIEWER_ID;
        this.RECORDING_ID = RECORDING_ID;
        this.RATING = RATING;
        this.REVIEW = REVIEW;
    }

    /*public boolean compare(Review aReview) {
    }*/

    @Override
    public boolean equals(Object o) {
        Review review = (Review) o;
        if (getID() != null ? !getID().equals(review.getID()) : review.getID() != null) return false;
        if (getREVIEWER_ID() != null ? !getREVIEWER_ID().equals(review.getREVIEWER_ID()) : review.getREVIEWER_ID() != null)
            return false;
        if (getRECORDING_ID() != null ? !getRECORDING_ID().equals(review.getRECORDING_ID()) : review.getRECORDING_ID() != null)
            return false;
        if (getRATING() != null ? !getRATING().equals(review.getRATING()) : review.getRATING() != null) return false;
        return getREVIEW() != null ? getREVIEW().equals(review.getREVIEW()) : review.getREVIEW() == null;

    }


}

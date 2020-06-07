package org.media.GatewayTests;

import org.junit.Before;
import org.junit.Test;
import org.media.dal.gateways.ReviewGateway;
import org.media.model.Review;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by shantonu on 2/27/17.
 */
public class ReviewGatewayTest {

    private ReviewGateway aReviewGateway;
    @Before
    public void init(){
        aReviewGateway = new ReviewGateway();
    }
    @Test
    public void testGetAReviewFromDB(){

    }
    @Test
    public void testGetAllReviewFromDB(){
        List<Review> allGenre = aReviewGateway.viewAll();
        assertTrue(allGenre.size()>0);
        for(Review aReview : allGenre){
            Review found = aReviewGateway.view(aReview.getID());
            assertEquals(found.getID(), aReview.getID());
            assertTrue(found.equals(aReview));
        }
    }
    @Test
    public void testDeleteAReviewFromDB(){}
    @Test
    public void testInsertAReviewFromDB(){}
    @Test
    public void testUpdateAReviewFromDB(){}
}

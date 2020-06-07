package org.media.GatewayTests;

import org.junit.Before;
import org.junit.Test;
import org.media.dal.gateways.ReviewerGateway;
import org.media.model.Genre;
import org.media.model.Reviewer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by shantonu on 2/27/17.
 */
public class ReviewerGatewayTest {
    private ReviewerGateway aReviewerGateway;
    @Before
    public void init(){
        aReviewerGateway = new ReviewerGateway();
    }

    @Test
    public void testGetAReviewerFromDB(){
    }
    @Test
    public void testGetAllReviewerFromDB(){
        List<Reviewer> allGenre = aReviewerGateway.viewAll();
        assertTrue(allGenre.size()>0);
        for(Reviewer aReviewer : allGenre){
            Reviewer found = aReviewerGateway.view(aReviewer.getID());
            assertEquals(found.getID(), aReviewer.getID());
            assertEquals(found.getNAME(), aReviewer.getNAME());
        }
    }
    @Test
    public void testDeleteAReviewerFromDB(){}
    @Test
    public void testInsertAReviewerFromDB(){}
    @Test
    public void testUpdateAReviewerFromDB(){}
}


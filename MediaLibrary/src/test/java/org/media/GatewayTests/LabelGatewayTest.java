package org.media.GatewayTests;

import org.junit.Before;
import org.junit.Test;
import org.media.dal.gateways.LabelGateway;
import org.media.model.Genre;
import org.media.model.Label;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by shantonu on 2/25/17.
 */
public class LabelGatewayTest {
    private LabelGateway aLabelGateway;
    @Before
    public void init(){
        aLabelGateway = new LabelGateway();
    }

    @Test
    public void testGetALabelFromDB(){
        List<Label> allGenre = aLabelGateway.viewAll();
        assertTrue(allGenre.size()>0);
        for(Label aLabel : allGenre){
            Label found = aLabelGateway.view(aLabel.getID());
            assertEquals(found.getID(), aLabel.getID());
            assertEquals(found.getNAME(), aLabel.getNAME());
        }
    }
    @Test
    public void testGetAllLabelFromDB(){}
    @Test
    public void testDeleteALabelFromDB(){}
    @Test
    public void testInsertALabelFromDB(){}
    @Test
    public void testUpdateALabelFromDB(){}
}

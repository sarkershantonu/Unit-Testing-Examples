package org.media.GatewayTests;

import org.junit.Before;
import org.junit.Test;
import org.media.dal.gateways.RecordingGateway;
import org.media.model.Genre;
import org.media.model.Recording;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by shantonu on 2/26/17.
 */
public class RecordingGatewayTest {
    private RecordingGateway aRecordingGateway;
    @Before
    public void init(){
        aRecordingGateway = new RecordingGateway();
    }

    @Test
    public void testGetARecordingFromDB(){
        List<Recording> allGenre = aRecordingGateway.viewAll();
        assertTrue(allGenre.size()>0);
        for(Recording aRecording : allGenre){
            Recording found = aRecordingGateway.view(aRecording.getID());
            assertEquals(found.getID(), aRecording.getID());
            assertTrue(found.equals(aRecording));
        }
    }
    @Test
    public void testGetAllRecordingFromDB(){}
    @Test
    public void testDeleteARecordingFromDB(){}
    @Test
    public void testInsertARecordingFromDB(){}
    @Test
    public void testUpdateARecordingFromDB(){}
}

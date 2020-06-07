package org.media.GatewayTests;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.media.TestBase;
import org.media.dal.gateways.ArtistGateway;
import org.media.model.Artist;
import org.media.utils.IDGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by shantonu on 1/31/17.
 */
public class ArtistGatewayTest extends TestBase {
    private ArtistGateway anArtistGateway;
    @Before
    public void init(){
        anArtistGateway = new ArtistGateway();
    }

    //todo
    @Test
    public void testGetAnArtistFromDB(){
        Artist artist = null;
        artist = anArtistGateway.view("Name");
        assertEquals("Name", artist.getNAME());
        artist = anArtistGateway.view(1);
        assertEquals(Integer.valueOf(1), artist.getID());
        Integer id = anArtistGateway.insert(new Artist(99, "shantonu"));
        artist = anArtistGateway.view(id);
        assertEquals(Integer.valueOf(1), artist.getID());
    }

    @Test
    public void testGetAllArtistFromDB(){
        List<Artist> allArtist = anArtistGateway.viewAll();
        assertTrue(allArtist.size()>0);
        for(Artist artist : allArtist){
            Artist found = anArtistGateway.view(artist.getID());
            assertEquals(found.getID(), artist.getID());
            assertEquals(found.getNAME(), artist.getNAME());
        }
    }
    @Test
    public void testDeleteAnArtistFromDB() throws SQLException {
        Integer testId = IDGenerator.getNextID(ArtistGateway.TABLE);;
        String name = "DeteleThis";

       System.out.print( anArtistGateway.insert(new Artist(testId,name)));
       // anArtistGateway.remove(testId);
        String q = "SELECT * from "+ ArtistGateway.TABLE +" where ID="+testId;
        Statement pt = aConnection.createStatement();
        ResultSet resultSet = pt.executeQuery(q);
        assertNull(resultSet);
    }
    @Test
    public void testUpdateAnArtistFromDB(){
        Integer artistId = IDGenerator.getNextID(ArtistGateway.TABLE);
        Artist anArtist = new Artist(artistId,"sha");
        anArtistGateway.insert(anArtist);
        anArtist = new Artist(artistId,"sarker");
        assertEquals(artistId,anArtistGateway.update(anArtist));
        assertTrue(anArtist.equals(anArtistGateway.view(artistId)));
        anArtistGateway.remove(artistId);
    }
    @Test
    public void testInsertAnArtistFromDB(){
        Integer artistId = IDGenerator.getNextID(ArtistGateway.TABLE);
        Artist anArtist = new Artist(artistId,"inserted");
        assertEquals(1, anArtistGateway.insert(anArtist).intValue());
        assertEquals(anArtist.getNAME(), anArtistGateway.view(artistId).getNAME());
        //anArtistGateway.remove(artistId);
    }
}

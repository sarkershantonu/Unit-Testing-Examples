package org.media.GatewayTests;

import org.junit.Before;
import org.junit.Test;
import org.media.TestBase;
import org.media.dal.gateways.GenreGateway;
import org.media.model.Genre;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by shantonu on 2/25/17.
 * todo, error
 */
public class GenreGatewayTest extends TestBase{
    private GenreGateway aGenreGateway;
    @Before
    public void init(){
        aGenreGateway = new GenreGateway();
    }
    @Test
    public void testGetAllGenreFromDB(){
        List<Genre> allGenre = aGenreGateway.viewAll();
        assertTrue(allGenre.size()>0);
        for(Genre Genre : allGenre){
            Genre found = aGenreGateway.view(Genre.getID());
            assertEquals(found.getID(), Genre.getID());
            assertEquals(found.getNAME(), Genre.getNAME());
        }
    }
    @Test
    public void testGetAGenreFromDB(){

    }
    @Test
    public void testDeleteAGenreFromDB(){}
    @Test
    public void testInsertAGenreFromDB(){}
    @Test
    public void testUpdateAGenreFromDB(){}
}

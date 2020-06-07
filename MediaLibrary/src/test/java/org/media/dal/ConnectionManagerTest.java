package org.media.dal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.media.App;
import org.media.TestBase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by shantonu on 1/27/17.
 */
public class ConnectionManagerTest {
    private static Connection aConnection;

    @BeforeClass
    public static void loadProperties() {
        try {
            App.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCunnectionUrl() {
        Assert.assertNotNull(ConnectionManager.url);
        Assert.assertEquals("jdbc:mysql://localhost:3306/db_medialib", ConnectionManager.url);
    }

     @Test
    public void testConnectionOpen() throws SQLException {
        aConnection = ConnectionManager.getConn();
        Assert.assertNotNull(aConnection);
        Assert.assertFalse(aConnection.isClosed());
    }

    @Test
    public void testConnectionClose() throws SQLException {
        aConnection = ConnectionManager.getConn();
        ConnectionManager.close();
        Assert.assertTrue(aConnection.isClosed());
    }
}

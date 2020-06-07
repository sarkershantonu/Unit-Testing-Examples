package org.media;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.media.dal.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by shantonu on 1/27/17.
 */
public abstract class TestBase {
    protected static Connection aConnection;

    @BeforeClass
    public static void initClass(){
        try {
            App.class.newInstance();
            aConnection = ConnectionManager.getConn();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public static void tearDownClass(){
        try {
           ConnectionManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

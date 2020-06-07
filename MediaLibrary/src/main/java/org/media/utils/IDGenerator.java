package org.media.utils;

import org.media.config.AppProperty;
import org.media.dal.ConnectionManager;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by shantonu on 2/17/17.
 */
public class IDGenerator {
//decision 1 : lets keep IDs in seperate table in DB
    public static Integer giveMeNextId(String tableName){
        Integer result = null;
        try {
            final String q ="select id from t_ID where table='"+tableName+"'";
            Connection aConnection = ConnectionManager.getConn();
            Statement pt = aConnection.createStatement();
            ResultSet resultSet = pt.executeQuery(q);
            ResultSetHelper.getFirstItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Integer getNextID(String tableName){
        final String propertypath = "src/main/resources/table.properties";
        Properties props = AppProperty.loadProperties(propertypath);
        Integer result = Integer.valueOf(props.getProperty(tableName+".id"));
        props.setProperty(tableName+".id",String.valueOf(result+1));
        AppProperty.save(propertypath,props);
        return result;
    }

}

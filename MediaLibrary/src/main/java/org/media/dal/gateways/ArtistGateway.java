package org.media.dal.gateways;

import static org.media.utils.ResultSetHelper.*;

import org.media.core.Gateway;
import org.media.model.Artist;
import org.media.utils.ResultSetHelper;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shantonu on 1/31/17.
 */
public class ArtistGateway extends GatewayBase implements Gateway<Artist> {
    public static final String TABLE ="t_Artist";
    public List<Artist> viewAll(){
        String query = "select* from "+ TABLE;
        List<Artist> all = null;
        try {
            all= getAsList(executeQuery(query),Artist.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return all;
    }

    public Artist view(String name) {
        String q = "SELECT * from "+ TABLE +" where NAME='"+name+"'";
        Artist found = null;
        try {
            ResultSet resultSet = executeQuery(q);
            found = (Artist) ResultSetHelper.getFirstItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return found;
    }
    public Artist view(Integer id)  {
        String q = "SELECT * from "+ TABLE +" where ID="+id.toString();
        ResultSet resultSet = null;
        Artist result = null;
        try {
           resultSet =  executeQuery(q);
            result = ResultSetHelper.getItem(resultSet,Artist.class);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer insert(Artist anArtist) {
        //anArtist.setID(IDGenerator.getNextID(table));
        String q = "INSERT INTO "+ TABLE +" VALUES ("+anArtist.getID()+", \""+anArtist.getNAME()+"\")";
        int id = 0;
        try {
           id =  executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void remove(Integer id) {
       String q = "DELETE FROM "+ TABLE +" where ID="+id.toString();
        try {
            executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Artist artist) {
        String q = "DELETE FROM "+ TABLE +" where ID="+artist.getID().toString();
        try {
            executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Integer update(Artist anArtist) {
        String q="UPDATE "+ TABLE +" SET NAME='"+anArtist.getNAME()+"' WHERE ID="+anArtist.getID();
        try {
            executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return anArtist.getID();
    }
}

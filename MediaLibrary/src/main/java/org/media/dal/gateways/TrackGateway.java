package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Track;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;

/**
 * Created by ssarker on 2/5/2017.
 */
public class TrackGateway extends GatewayBase implements Gateway<Track> {
    private static final String table="t_Track";
    @Override
    public List<Track> viewAll() {
        String query = "select* from "+table;
        List<Track> all = null;
        try {
            all= getAsList(executeQuery(query),Track.class);
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

    @Override
    public Track view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Track();
    }

    @Override
    public Integer insert(Track track) {
        String q = "INSERT INTO "+table+" VALUES ("
                +track.getID()+", \""
                +track.getTITLE()+"\",\""
                +track.getDURATION()+"\","
                +track.getGENRE_ID()+","+
                +track.getARTIST_ID()+","+
                +track.getRECORDING_ID()+")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return track.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Track track) {

    }

    @Override
    public Integer update(Track track) {
        return null;
    }
}

package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Recording;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;

/**
 * Created by ssarker on 2/5/2017.
 */
public class RecordingGateway extends GatewayBase implements Gateway<Recording> {
    private static final String table="t_Recording";
    @Override
    public List<Recording> viewAll() {
        String query = "select* from "+table;
        List<Recording> all = null;
        try {
            all= getAsList(executeQuery(query),Recording.class);
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
    public Recording view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Recording();
    }

    @Override
    public Integer insert(Recording recording) {
        String q = "INSERT INTO "+table+" VALUES ("
                +recording.getID()+", \""
                +recording.getTITLE()+"\",\""
                +new SimpleDateFormat("dd/MM/yyyy").format(recording.getRELEASE_DATE())+"\", "
                +recording.getART_ID()+","+
                recording.getLABEL_ID()+")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recording.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Recording recording) {

    }

    @Override
    public Integer update(Recording recording) {
        return null;
    }
}

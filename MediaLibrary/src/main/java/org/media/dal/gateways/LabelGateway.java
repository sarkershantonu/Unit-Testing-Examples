package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Label;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;


/**
 * Created by ssarker on 2/5/2017.
 */
public class LabelGateway  extends GatewayBase implements Gateway<Label> {
    private static final String table="t_Label";
    @Override
    public List<Label> viewAll() {
        String query = "select* from "+table;
        List<Label> all = null;
        try {
            all= getAsList(executeQuery(query),Label.class);
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
    public Label view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Label();
    }
    public Label view(String name) {
        String q = "SELECT * from "+table+" where NAME='"+name+"'";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Label();
    }

    @Override
    public Integer insert(Label label) {
        String q = "INSERT INTO "+table+" VALUES ("
                +label.getID()+", \""+label.getNAME()+"\")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return label.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Label label) {

    }

    @Override
    public Integer update(Label label) {
        return null;
    }
}

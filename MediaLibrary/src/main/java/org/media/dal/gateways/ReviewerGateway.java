package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Reviewer;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;


/**
 * Created by ssarker on 2/5/2017.
 */
public class ReviewerGateway extends GatewayBase implements Gateway<Reviewer> {
    private static final String table="t_Artist";
    @Override
    public List<Reviewer> viewAll() {
        String query = "select* from "+table;
        List<Reviewer> all = null;
        try {
            all= getAsList(executeQuery(query),Reviewer.class);
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
    public Reviewer view(String name) {
        String q = "SELECT * from "+table+" where NAME='"+name+"'";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Reviewer();
    }
    @Override
    public Reviewer view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Reviewer();
    }

    @Override
    public Integer insert(Reviewer reviewer) {
        String q = "INSERT INTO "+table+" VALUES ("
                +reviewer.getID()+", \""
                +reviewer.getNAME()+"\")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviewer.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Reviewer reviewer) {

    }

    @Override
    public Integer update(Reviewer reviewer) {
        return null;
    }
}

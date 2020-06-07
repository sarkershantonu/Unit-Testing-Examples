package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Genre;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;


/**
 * Created by ssarker on 2/5/2017.
 */
public class GenreGateway  extends GatewayBase implements Gateway<Genre> {
    private static final String table="t_Genre";

    @Override
    public List<Genre> viewAll() {
        String query = "select* from "+table;
        List<Genre> all = null;
        try {
            all= getAsList(executeQuery(query),Genre.class);
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
    public Genre view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Genre();
    }
    public Genre view(String name) {
        String q = "SELECT * from "+table+" where NAME='"+name+"'";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Genre();
    }
    @Override
    public Integer insert(Genre genre) {
        String q = "INSERT INTO "+table+" VALUES ("
                +genre.getID()+", \""+genre.getNAME()+"\")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genre.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Genre genre) {

    }

    @Override
    public Integer update(Genre genre) {
        return null;
    }
}

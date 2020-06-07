package org.media.dal.gateways;

import org.media.core.Gateway;
import org.media.model.Review;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.media.utils.ResultSetHelper.getAsList;

/**
 * Created by ssarker on 2/5/2017.
 */
public class ReviewGateway extends GatewayBase implements Gateway<Review> {
    private static final String table="t_Review";

    @Override
    public List<Review> viewAll() {
        String query = "select* from "+table;
        List<Review> all = null;
        try {
            all= getAsList(executeQuery(query),Review.class);
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
    public Review view(Integer id) {
        String q = "SELECT * from "+table+" where ID="+id.toString();

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Review();
    }

    @Override
    public Integer insert(Review review) {
        String q = "INSERT INTO "+table+" VALUES ("
                +review.getID()+","
                +review.getREVIEWER_ID()+","
                +review.getRECORDING_ID()+","
                +review.getRATING()+", \""
                +review.getREVIEW()+"\")";

        try {
            executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return review.getID();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Review review) {

    }

    @Override
    public Integer update(Review review) {
        return null;
    }
}

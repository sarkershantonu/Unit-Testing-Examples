package org.media.utils;

import org.media.dal.ConnectionManager;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shantonu on 1/27/17.
 */
public class ResultSetHelper {
    public ResultSetHelper() {
    }

    public static <T> List<T> getAsList(ResultSet resultSet, Class<T> tClass) throws
            SQLException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        List<T> listImtes = new ArrayList<T>();
        while (resultSet.next()) {
            T instance = tClass.newInstance();
            for (Field field : tClass.getDeclaredFields()) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), tClass);
                //System.out.println("PD " + pd.getName());
                Method method = pd.getWriteMethod();
              /*  System.out.println("Method : " + method.getName());
                System.out.println("Method : Parameter count " + method.getParameterCount());*/
                Class[] types = method.getParameterTypes();
                //System.out.println("Method : Parameter type "+types[0]);
                Object value = resultSet.getObject(field.getName());
                method.invoke(instance, (types[0]).cast(value));
            }
            listImtes.add(instance);
        }
        return listImtes;
    }

    public static <T> T getItem(ResultSet resultSet, Class<T> aClass) throws IllegalAccessException, InstantiationException, SQLException, IntrospectionException, InvocationTargetException {
        T instance = aClass.newInstance();
        resultSet.next();
        for (Field field : aClass.getDeclaredFields()) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), aClass);
            //System.out.println("PD " + pd.getName());
            Method method = pd.getWriteMethod();
              /*  System.out.println("Method : " + method.getName());
                System.out.println("Method : Parameter count " + method.getParameterCount());*/
            Class[] types = method.getParameterTypes();
            //System.out.println("Method : Parameter type "+types[0]);
            Object value = resultSet.getObject(field.getName());
            method.invoke(instance, (types[0]).cast(value));
        }
        return instance;
    }

    public static <T> T getFirstItem(ResultSet rs, Class<T> aClass) throws SQLException {
        rs.next();
        return (T)rs.getObject(1);
    }
    public static Object getFirstItem(ResultSet rs) throws SQLException {
        rs.next();
        return rs.getObject(1);
    }

}

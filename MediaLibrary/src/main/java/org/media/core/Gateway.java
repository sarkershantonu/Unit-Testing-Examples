package org.media.core;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shantonu on 2/7/17.
 */
public interface Gateway<T> {
    List<T> viewAll();

    T view(Integer id);

    Integer insert(T t);

    void remove(Integer id);

    void remove(T t);

    Integer update(T t);

}

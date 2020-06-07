package org.media;

import org.media.config.AppProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by shantonu on 1/26/17.
 */
public class App {
    static {
        AppProperty.loadProperties();
    }

}

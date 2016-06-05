package runner;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by shantonu on 6/5/16.
 */
public class TestNGRunner {
    public static void run() throws ParserConfigurationException, SAXException, IOException {
        List<XmlSuite> suit = new ArrayList<>();
        String xml = "testng.xml";
        suit = (List<XmlSuite>) new Parser(xml).parse();

        TestNG runner = new TestNG();
        runner.setXmlSuites(suit);
        runner.run();
    }
    public static void run(String xmlPath) throws IOException, SAXException, ParserConfigurationException {
        List<XmlSuite> suits = new ArrayList();
        suits = (List<XmlSuite>) new Parser(xmlPath).parse();
        new TestNG().setXmlSuites(suits);
    }
    public static void runAll(Collection<String> xmls) throws IOException, SAXException, ParserConfigurationException {
        List<XmlSuite> suits = new ArrayList();
        for(String xml:xmls){
        suits.addAll((List<XmlSuite>) new Parser(xml).parse());
        }
        new TestNG().setXmlSuites(suits);
    }
    public static void runAll(String folderPath) throws IOException, SAXException, ParserConfigurationException {
        File folder  = new File(folderPath);
        for(File f : folder.listFiles()){
            run(f.getName());
        }
    }
    public void runAllInResources() throws ParserConfigurationException, SAXException, IOException {
        runAll(System.getProperty("user.dir")+"/src/test/resources");
    }

}

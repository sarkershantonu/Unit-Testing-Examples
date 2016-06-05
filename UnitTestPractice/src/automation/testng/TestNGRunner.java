package automation.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

public class TestNGRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void testNGRunWithXml() throws ParserConfigurationException, SAXException, IOException{
		List<XmlSuite> suit = new ArrayList<>();
		String xml = "testng.xml";
		suit = (List<XmlSuite>) new Parser(xml).parse(); 
		
		TestNG runner = new TestNG();
		runner.setXmlSuites(suit);
		runner.run();
	}
}

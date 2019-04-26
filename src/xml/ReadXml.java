package xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/*
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
*/

/**
 * Created by morgannm on 12/02/2016.
 */
public class ReadXml {
    public static void main(String args[]) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true); // tenir compte des namespaces
        //builderFactory.setValidating(true); // validation du document XML par le parser
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Document xmlDoc = null;
        File fic = new File("resources\\NHL.xml");
        try
        {
            xmlDoc = builder.parse(fic);
            Element root = xmlDoc.getDocumentElement();
            System.out.println("Root element : " + root.getNodeName());
        }
        catch(SAXException | IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Terminé");
    }
}

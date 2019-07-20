package xml;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Created by morgannm on 12/02/2016.
 */
public class ReadXml {

    public static void main(String args[]) {
        openXMLFile("resources\\NHL.xml", false);
        openXMLFile("resources\\NHL_DTD.xml", true  );
        System.out.println("Terminé");
    }

    private static void openXMLFile(String pathName, boolean validate) {
        System.out.println("Ouverture de " + pathName);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true); // tenir compte des namespaces
        if (validate) {
            builderFactory.setValidating(true); // validation du document XML par le parser
        }
        DocumentBuilder  builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Document xmlDoc = null;
        File fic = new File(pathName);
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

    }
}

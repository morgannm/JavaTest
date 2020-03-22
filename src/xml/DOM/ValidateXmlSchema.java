package xml.DOM;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidateXmlSchema {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            //Ces trois lignes servent à informer que la validation se fait via un fichier XSD
            SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //On créé notre schéma XSD
            //Ici, c'est un schéma interne, pour un schéma externe il faut mettre l'URI
            Schema schema = sfactory.newSchema(new File("resources\\NHL_ref.xsd"));
            //On l'affecte à notre factory afin que le document prenne en compte le fichier XSD
            factory.setSchema(schema);

            DocumentBuilder builder = factory.newDocumentBuilder();

            //création de notre objet d'erreurs
            ErrorHandler errHandler = new SimpleErrorHandler();
            //Affectation de notre objet au document pour interception des erreurs éventuelles
            builder.setErrorHandler(errHandler);


            //On rajoute un bloc de capture
            //pour intercepter les erreurs au cas où il y en ait
            try {
                // 1) Validation correcte
                System.out.println("1) TestThread1 avec validaton correcte");
                File fileXML = new File("resources\\NHL2.xml");
                Document xml = builder.parse(fileXML);
                Element root = xml.getDocumentElement();
                System.out.println("L'élément racine du document est : " + root.getNodeName());

                System.out.println();
                System.out.println("2) TestThread1 avec validaton incorrecte");
                fileXML = new File("resources\\NHL_Bad_Schema_ref.xml");
                xml = builder.parse(fileXML);

            } catch (SAXParseException e) {}

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SimpleErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("WARNING : " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            System.out.println("ERROR : " + e.getMessage());
            throw e;
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("FATAL ERROR : " + e.getMessage());
            throw e;
        }
    }
}

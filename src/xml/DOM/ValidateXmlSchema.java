package xml.DOM;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
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
                System.out.println("1) Fichier XML avec validaton correcte");
                File fileXML = new File("resources\\NHL2.xml");
                Document xml = builder.parse(fileXML);
                Element root = xml.getDocumentElement();
                System.out.println("L'élément racine du document est : " + root.getNodeName());

                System.out.println();
                System.out.println("2) String XML avec validaton correcte");
                // Si le XML à valider est une chaîne de caractères
                String strXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" +
                        "<NHL> <!-- Ok avec NHL.xsd, NHL_ref.xsd, NHL_type.xsd -->\n" +
                        "    <Teams>\n" +
                        "        <Team Name=\"Golden Knights\" City=\"Las Vegas\" Creation=\"2017\" ID=\"GoldenKnights\" WebSite=\"https://www.nhl.com/goldenknights\">\n" +
                        "            <StanleyCups/>\n" +
                        "            <Players>\n" +
                        "                <Player Name=\"Engelland\" Number=\"5\" ID=\"Engelland\" FirstName=\"Derek\"/>\n" +
                        "                <Player Name=\"Fleury\" FirstName=\"Marc-André\" Number=\"29\" ID=\"Fleury\"/>\n" +
                        "                <Player Name=\"Karlsson\" FirstName=\"William\" Number=\"71\" ID=\"Karlsson\"/>\n" +
                        "                <Player Name=\"Marchessault\" FirstName=\"Jonathan\" Number=\"81\" ID=\"Marchessault\"/>\n" +
                        "                <Player Name=\"Carrier\" FirstName=\"William\" ID=\"Carrier\"/>\n" +
                        "                <Player Name=\"Eakin\" Number=\"21\" ID=\"Eakin\" FirstName=\"Cody\"/>\n" +
                        "            </Players>\n" +
                        "            <Rows>\n" +
                        "                <Row Type=\"Forward\" Players=\"Marchessault Karlsson\"/>\n" +
                        "                <Row Type=\"Forward\" Players=\"Carrier\"/>\n" +
                        "                <Row Type=\"Defense\" Players=\"Engelland\"/>\n" +
                        "                <Row Type=\"Goaltender\" Players=\"Fleury\"/>\n" +
                        "            </Rows>\n" +
                        "            <Coach Name=\"Gallant\" FirstName=\"Gerard\" />\n" +
                        "        </Team>\n" +
                        "        <Team Name=\"Rangers\" City=\"New-York\" ID=\"Rangers\">\n" +
                        "            <Players>\n" +
                        "                <Player ID=\"Panarin\" Name=\"Panarin\" FirstName=\"Artemi\" Number=\"10\" />\n" +
                        "                <Player ID=\"Howden\" Name=\"Howden\" FirstName=\"Brett\" Number=\"21\" />\n" +
                        "            </Players>\n" +
                        "            <Coach Name=\"Quinn\" FirstName=\"David\" />\n" +
                        "        </Team>\n" +
                        "        <Team Name=\"Ducks\" City=\"Anaheim\" ID=\"Ducks\">\n" +
                        "            <!-- Anaheim Ducks -->\n" +
                        "            <StanleyCups/>\n" +
                        "            <Players>\n" +
                        "                <Player ID=\"Sprong\" Name=\"Sprong\" FirstName=\"Daniel\" />\n" +
                        "            </Players>\n" +
                        "            <Coach Name=\"Murray\" FirstName=\"Robert\" />\n" +
                        "        </Team>   \n" +
                        "        <Team Name=\"Canadians\" City=\"Montreal\" ID=\"Canadians\">\n" +
                        "            <StanleyCups>\n" +
                        "                <StanleyCup>1986</StanleyCup>\n" +
                        "                <StanleyCup>1993</StanleyCup>\n" +
                        "            </StanleyCups>\n" +
                        "            <Players>\n" +
                        "                <Player ID=\"Price\" Name=\"Price\" FirstName=\"Carrey\" />\n" +
                        "            </Players>\n" +
                        "            <Rows>\n" +
                        "                <Row/>\n" +
                        "            </Rows>\n" +
                        "            <Coach Name=\"Julien\" FirstName=\"Claude\" />\n" +
                        "        </Team>\n" +
                        "        <Team Name=\"Blues\" City=\"St-Louis\" ID=\"Blues\">\n" +
                        "            <Players>\n" +
                        "                <Player ID=\"OReilly\" Name=\"O'Reilly\" FirstName=\"Ryan\" />\n" +
                        "            </Players>\n" +
                        "            <Coach Name=\"Berube\" FirstName=\"Craig\" />\n" +
                        "        </Team>\n" +
                        "    </Teams>\n" +
                        "    <Conferences>\n" +
                        "        <Conference Name=\"Eastern\">\n" +
                        "            <Division Name=\"Atlantic\">\n" +
                        "                <Team ID=\"Canadians\"/>\n" +
                        "            </Division>\n" +
                        "            <Division Name=\"Metropolitan\">\n" +
                        "                <Team ID=\"Rangers\"/>\n" +
                        "            </Division>\n" +
                        "        </Conference>\n" +
                        "        <Conference Name=\"Western\">\n" +
                        "            <Division Name=\"Central\">\n" +
                        "                <Team ID=\"Blues\"/>\n" +
                        "            </Division>\n" +
                        "            <Division Name=\"Pacific\">\n" +
                        "                <Team ID=\"GoldenKnights\"/>\n" +
                        "            </Division>\n" +
                        "        </Conference>\n" +
                        "    </Conferences>\n" +
                        "    <Arbitrage>Toronto</Arbitrage>    \n" +
                        "</NHL>";
                InputSource is = new InputSource(new StringReader(strXml));
                xml = builder.parse(is);
                root = xml.getDocumentElement();
                System.out.println("L'élément racine du document est : " + root.getNodeName());

                System.out.println();
                System.out.println("3) Fichier XML avec validaton incorrecte");
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

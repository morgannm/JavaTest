package xml.DOM;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by morgannm on 12/02/2016.
 */
public class DOMDemo {

    public static void main(String args[]) {
        ReadXmlFile();
        //ParseXmlFileFromStream();
    }

    private static void ParseXmlFileFromStream() {
        System.out.println("================================================");
        System.out.println("Parse XML file from Stream");
        // Instance de factory qui se chargera de fournir un parseur
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Création du parseur via la factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("resources\\NHL_Schema_ref.xml");

            // Parsing d'un XML via un flux
            InputStream is = new FileInputStream(fileXML);
            Document document = builder.parse(is); // création de la structure en mémoire
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void ReadXmlFile() {
        System.out.println("================================================");
        System.out.println("Parse and read XML file from File");
        final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder builder = builderFactory.newDocumentBuilder();
            final Document document = builder.parse(new File("resources\\NHL_Schema_ref.xml"));

            //Affiche la version de XML
            System.out.println("Xml Version : " + document.getXmlVersion());

            //Affiche l'encodage
            System.out.println("Encoding : " + document.getXmlEncoding());

            //Affiche s'il s'agit d'un document standalone
            System.out.println("Document Standalone : " + document.getXmlStandalone());

            final Element root = document.getDocumentElement();
            System.out.println("Nom de la racine : " + root.getNodeName());

            Node teams2 = root.getFirstChild();

            final NodeList nodeList = root.getChildNodes();
            for (int i=0; i<nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("------------------");
                    System.out.println(nodeList.item(i).getNodeName() + " : ");
                    switch (nodeList.item(i).getNodeName()) {
                        case "Teams":
                            final NodeList teams = nodeList.item(i).getChildNodes();
                            for (int t=0; t<teams.getLength(); t++) {
                                if (teams.item(t).getNodeType() == Node.ELEMENT_NODE) {
                                    //System.out.println(teams.item(t).getNodeName());
                                    final Element team = (Element) teams.item(t);
                                    System.out.println(team.getAttribute("Name"));

                                    final NodeList players = ((Element)team.getElementsByTagName("Players").item(0)).getElementsByTagName("Player");
                                    if (players.getLength()>0) {
                                        System.out.println("Players : ");
                                        for (int p=0;p<players.getLength();p++) {
                                            final Element player = (Element)players.item(p);
                                            System.out.println(player.getAttribute("FirstName") + " " + player.getAttribute("Name"));
                                        }
                                    }
                                    final Element coach = (Element)team.getElementsByTagName("Coach").item(0);
                                    if (coach != null) {
                                        System.out.println("Coach : " + coach.getAttribute("FirstName") + " " + coach.getAttribute("Name"));
                                    }

                                }
                            }
                            break;
                        case "Arbitrage":
                            System.out.println(((Element) nodeList.item(i)).getTextContent());
                            break;
                    }
                }
            }

        }
        catch(final ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (final SAXException e) {
            e.printStackTrace();
        }
        catch (final IOException e) {
            e.printStackTrace();
        }

    }
}

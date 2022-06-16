package xml.DOM;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXml_iTunes {
    public static void main(String[] args) {
        Document docITunes = null;
        DOMParser parser = null;

        /*
        try {
            parser = new DOMParser();
            parser.parse("C:\\Temp\\iTunes.xml");
            docITunes = parser.getDocument();
            System.out.println("Xml Version : " + docITunes.getXmlVersion());
            System.out.println("Encoding : " + docITunes.getXmlEncoding());
            System.out.println("Document Standalone : " + docITunes.getXmlStandalone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


        final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //final Document document = builder.parse(new File("resources\\iTunesTest.xml"));
            final Document document = builder.parse(new File("C:\\Temp\\iTunes1.xml"));

            //Affiche la version de XML
            System.out.println("Xml Version : " + document.getXmlVersion());

            //Affiche l'encodage
            System.out.println("Encoding : " + document.getXmlEncoding());

            //Affiche s'il s'agit d'un document standalone
            System.out.println("Document Standalone : " + document.getXmlStandalone());

            final Element root = document.getDocumentElement();
            System.out.println("Root : " + root.getNodeName());
            if (root.getNodeName().equals("plist")) {
                NodeList nodeList = root.getChildNodes();
                System.out.println("nodeList : " + nodeList.getLength());
                NodeList keyList;
                String artist="";
                String album="";
                String year="";
                int i=0;
                while (i<nodeList.getLength()) {
                    if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE && nodeList.item(i).getNodeName().equals("dict")) {
                        System.out.println("dict niveau 1 trouvé");
                        nodeList = nodeList.item(i).getChildNodes();
                        // cherche le 1er noeud "dict" (1 seul en principe)
                        i=0;
                        while (i<nodeList.getLength()) {
                            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE && nodeList.item(i).getNodeName().equals("dict")) {
                                Node musicDict = nodeList.item(i);
                                System.out.println("dict niveau 2 trouvé " + musicDict.getNodeName());
                                NodeList trackList = musicDict.getChildNodes();
                                //NodeList trackList = nodeList.item(i).getChildNodes();
                                for (int j=0; j<trackList.getLength(); j++) {
                                    if (trackList.item(j).getNodeType() == Node.ELEMENT_NODE && trackList.item(j).getNodeName().equals("dict")) {
                                        //System.out.println("track " + j);
                                        keyList = trackList.item(j).getChildNodes();
                                        //ReadTrack(trackList.item(j));
                                        for (int k=0; k<keyList.getLength(); k++) {
                                            switch (keyList.item(k).getTextContent()) {
                                                case "Artist":
                                                    artist = keyList.item(k).getNextSibling().getTextContent();
                                                    break;
                                                case "Album":
                                                    album = keyList.item(k).getNextSibling().getTextContent();
                                                    break;
                                                case "Year":
                                                    year = keyList.item(k).getNextSibling().getTextContent();
                                                    break;
                                            }
                                        }
                                        System.out.println(artist + " - " + album + " - " + year);
                                    }
                                }
                                break;
                            }
                            i++;
                        }
                        break;
                    }
                    i++;
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

    private static void ReadTrack(Node track) {
        NodeList keyList = track.getChildNodes();
        String artist="";
        String album="";
        String year="";
        for (int i=0; i<keyList.getLength(); i++) {
            switch (keyList.item(i).getTextContent()) {
                case "Artist":
                    artist = keyList.item(i).getNextSibling().getTextContent();
                    break;
                case "Album":
                    album = keyList.item(i).getNextSibling().getTextContent();
                    break;
                case "Year":
                    year = keyList.item(i).getNextSibling().getTextContent();
                    break;
            }
            /*
            if (keyList.item(i).getTextContent().equals("Artist")) {
                Node value = keyList.item(i).getNextSibling();
                System.out.println(value.getTextContent());
            }
             */
        }
        System.out.println(artist + " - " + album + " - " + year);
    }
}

package xml.DOM;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class WriteXML {
    public static void main(String[] args) {
        final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder builder = builderFactory.newDocumentBuilder();
            final Document document = builder.newDocument();

            // Création de l'élément racine
            final Element NHL = document.createElement("NHL");
            document.appendChild(NHL);

            // Création d'un commentaire
            final Comment comment = document.createComment("National Hockey Ligue");
            NHL.appendChild(comment);

            final Element teams = document.createElement("Teams");
            NHL.appendChild(teams);
            final Element VGK = document.createElement("Team");
            VGK.setAttribute("Name","Golden Knights");
            teams.appendChild(VGK);
            final Element NYR = document.createElement("Team");
            NYR.setAttribute("Name", "Rangers");
            teams.appendChild(NYR);

            final Element conferences = document.createElement("Conferences");
            NHL.appendChild(conferences);

            // Affichage du document XML
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            try {
                final Transformer transformer = transformerFactory.newTransformer();
                final DOMSource source = new DOMSource(document);
                final StreamResult result = new StreamResult(System.out);
                transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

                // Formatage de l'affichage
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                // affichage
                transformer.transform(source, result);
            } catch (final TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (final TransformerException e) {
                e.printStackTrace();
            }

        }
        catch(final ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}

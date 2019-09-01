package xml.XPath;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathDemo {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("resources/NHL3.xml");
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            XPathFactory xpf = XPathFactory.newInstance();
            XPath path = xpf.newXPath();

            // retourne la valeur texte d'un noeud
            String expression = "/NHL/Conference/Division";
            String str = (String)path.evaluate(expression, root);
            System.out.println(str);
            System.out.println("-------------------------------------");

            // retourne True car il y a au moins un noeud "Division" dans le document
            expression = "//Division";
            boolean bool = (Boolean)path.evaluate(expression, root, XPathConstants.BOOLEAN);
            System.out.println("Test de l'existence d'un noeud : " + bool);
            System.out.println("-------------------------------------");

            // retourne False car il y n'a pas de noeud "Division" à la racine du document
            expression = "/Division";
            bool = (Boolean)path.evaluate(expression, root, XPathConstants.BOOLEAN);
            System.out.println("Test de l'absence d'un noeud : " + bool);
            System.out.println("-------------------------------------");

            //2ème noeud Division
            expression = "//Division[2]";
            //Nous castons le résultat en Node
            Node node = (Node)path.evaluate(expression, root, XPathConstants.NODE);
            //Nous affichons son contenu
            System.out.println(node.getNodeName() + " : " + node.getTextContent());

            //1er noeud Team du noeud Division récupéré précédemment
            expression = "Team[1]";
            Element division = (Element)node;
            node = (Node)path.evaluate(expression, division, XPathConstants.NODE);
            System.out.println(node.getNodeName() + " : " + node.getTextContent());

            //
            expression = "/NHL/Teams/Team[4]/StanleyCups/StanleyCup[1]";
            str = (String)path.evaluate(expression, root);
            System.out.println(str);
            System.out.println("-------------------------------------");

            expression = "/NHL/Teams/Team[4]/StanleyCups/StanleyCup[2]";
            str = (String)path.evaluate(expression, root);
            System.out.println(str);
            System.out.println("-------------------------------------");

            expression = "NHL/Teams/Team[1]/Players/Player[2]";
            str = (String)path.evaluate(expression, root);
            System.out.println(str);
            System.out.println("-------------------------------------");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}

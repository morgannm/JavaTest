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
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Retourne les valeurs texte du 1er noeud Division trouvé dans /NHL/Conference");
            String expression = "/NHL/Conference/Division";
            String str = (String)path.evaluate(expression, root);
            System.out.println(str);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Teste l'existence d'au moins un noeud 'Division'");
            expression = "//Division";
            boolean bool = (Boolean)path.evaluate(expression, root, XPathConstants.BOOLEAN);
            // retourne True car il y a au moins un noeud "Division" dans le document
            System.out.println("Expression évaluée : //Division => " + bool);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Teste l'existence d'un noeud 'Division' à la racine du document");
            expression = "/Division";
            bool = (Boolean)path.evaluate(expression, root, XPathConstants.BOOLEAN);
            // retourne False car il y n'a pas de noeud "Division" à la racine du document
            System.out.println("Expression évaluée : /Division => " + bool);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Retourne le 2ème noeud 'Division' depuis la racine du document");
            expression = "//Division[2]";
            //Nous castons le résultat en Node
            Node node = (Node)path.evaluate(expression, root, XPathConstants.NODE);
            //Nous affichons son contenu
            System.out.println(node.getNodeName() + " : " + node.getTextContent());

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Retourne le 1er noeud Team du noeud Division récupéré précédemment");
            expression = "Team[1]";
            Element division = (Element)node;
            node = (Node)path.evaluate(expression, division, XPathConstants.NODE);
            System.out.println(node.getNodeName() + " : " + node.getTextContent());

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("/NHL/Conference[2]/Division[2]/Team[5]");
            expression = "/NHL/Conference[2]/Division[2]/Team[5]";
            str = (String)path.evaluate(expression, root);
            System.out.println(str);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Récupération de listes de noeuds");
            expression = "//Division";
            NodeList list = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
            int nodesLength = list.getLength();
            for(int i = 0; i<nodesLength; i++) {
                Node n = list.item(i);
                System.out.println(n.getNodeName() + " : " + n.getTextContent());
                NodeList teams = (NodeList)path.evaluate("Team", n , XPathConstants.NODESET);
                int nTeams = teams.getLength();
                for (int j=0; j<nTeams; j++) {
                    Node team = teams.item(j);
                    System.out.println("Team : " + team.getTextContent());
                }
            }

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Récupération d'une valeur de type nombre ");
            expression = "//StanleyCup[2]"; // 2ème noeud StanleyCup du document depuis la racine
            int annee = ((Double)path.evaluate(expression,root,XPathConstants.NUMBER)).intValue();
            System.out.println("Année coupe Stanley Canadiens : " + annee);

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Récupération d'une valeur de type chaine ");
            expression = "//Team[3]"; // 3ème noeud Team du document depuis la racine
            String teamStr = (String)path.evaluate(expression,root,XPathConstants.STRING);
            System.out.println(expression + " : " + teamStr);

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

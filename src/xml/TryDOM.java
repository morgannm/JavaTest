package xml;

import java.io.*;
import java.nio.file.*;
import java.util.Vector;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class TryDOM implements ErrorHandler {
  public static void main(String args[]) {
//    if(args.length == 0) {
//      System.out.println("No file to process." + "Usage is:\njava TryDOM \"filename\"");
//      System.exit(1);
//    }
    
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
    System.out.println("Builder Factory = " + builderFactory +"\nBuilder = " + builder);
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
     
    //Path xmlFile = Paths.get(args[0]);
    Path xmlFile = Paths.get("C:\\Temp\\NHL.xml");
    Document xmlDoc = null;
    try (BufferedInputStream in = new BufferedInputStream(Files.newInputStream(xmlFile))){
        File fic = new File("resources\\NHL.xml");
        //xmlDoc = builder.parse(in);
        xmlDoc = builder.parse(fic);
        
        // Racine du document
        Element root = xmlDoc.getDocumentElement();

        // 1) Lit tous les noeuds enfants
        System.out.println("1) Lit tous les noeuds enfants");
        NodeList children = root.getChildNodes(); // Noeuds enfants de la racine (éléments, text)
        Node[] nodes = new Node[children.getLength()]; // Déclare un tableau avec le nombre d'éléments enfants        
        for(int i = 0 ; i < nodes.length ; ++i) {
            nodes[i] = children.item(i);
            System.out.println(nodes[i].getNodeName());
        }
        
        // 2) Lit les noeuds de type élément seulement
        System.out.println("2) Lit les noeuds de type élément seulement");
        Vector<Element> elements = new Vector<>();
        Node node = null;
        Element elt = null;
        for(int i = 0 ; i < nodes.length; ++i) {
            node = children.item(i);
            if(node instanceof Element) {
                elements.add((Element) node);
                elt = (Element)node;                
                System.out.println(elt.getNodeName());
            }
        }
        
    } catch(SAXException | IOException e) {
        e.printStackTrace();
        System.exit(1);
    } 
  }

  public void fatalError(SAXParseException spe) throws SAXException {
    System.out.println("Fatal error at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
    throw spe;
  }

  public void warning(SAXParseException spe) {
    System.out.println("Warning at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
  }

  public void error(SAXParseException spe) {
    System.out.println("Error at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
  }
}

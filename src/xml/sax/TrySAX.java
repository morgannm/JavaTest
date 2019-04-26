package xml.sax;

import javax.xml.parsers.*;
import org.xml.sax.SAXException;

public class TrySAX {
  public static void main(String args[]) {
    // Create factory object
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setNamespaceAware(true);
    spf.setValidating(true);
    System.out.println("Parser will "+(spf.isNamespaceAware()?"":"not ") + "be namespace aware");
    System.out.println("Parser will "+(spf.isValidating()?"":"not ") + "validate XML");

    SAXParser parser = null;                 // Stores parser reference
    try {
     parser = spf.newSAXParser();            // Create parser object
    }catch(SAXException | ParserConfigurationException e){
      e.printStackTrace();
      System.exit(1);
    }

    System.out.println("Parser object is: " + parser);
  }
}

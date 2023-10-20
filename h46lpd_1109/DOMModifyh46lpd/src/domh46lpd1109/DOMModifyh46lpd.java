package domh46lpd1109;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMModifyh46lpd {
	public static void main(String[] args) {
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(new File("carsh46lpd.xml"));
			
			print(update(dom));
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static Node update(Document dom) {
		Node root = dom.getDocumentElement();
		Node elem = null;
				
		for (int i = 0; i < root.getChildNodes().getLength(); i++) {
			elem = root.getChildNodes().item(i);
			//System.out.println(elem.getParentNode().getNodeName());
			if(elem.getAttributes() != null) {
				if(elem.getAttributes().item(0).getNodeValue().compareTo("Ferrari") == 0) {
					elem.getAttributes().item(0).setNodeValue("Lamborghini");
					
					//System.out.println(elem.getAttributes().item(0).getNodeValue());
					for (int j = 0; j < elem.getChildNodes().getLength(); j++) {
						if(elem.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
							elem.getChildNodes().item(j).setTextContent("Lamborghini_" + elem.getChildNodes().item(j).getTextContent().split("_")[1]);
							//System.out.println(elem.getChildNodes().item(j).getTextContent());
						}
					}
					
				} else root.removeChild(elem);
			}			
		}
		
		return root;
	}
	
	public static void print(Node node) {		
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
            
            document.appendChild(document.adoptNode(node));
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("modifiedCarsU678MF.xml"));
            
            transformer.transform(domSource, console);
            transformer.transform(domSource, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

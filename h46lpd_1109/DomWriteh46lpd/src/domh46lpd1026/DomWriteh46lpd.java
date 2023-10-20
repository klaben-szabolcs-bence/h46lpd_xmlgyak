package domh46lpd1026;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DomWriteh46lpd {
	
	public void write() throws ParserConfigurationException, TransformerException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElementNS("domu678mf", "users");
        doc.appendChild(root);

        try {
        	for (Node node : createUser(doc)) {
        		root.appendChild(node);
			}
		} catch (DOMException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);
        
        File myFile = new File("user1h46lpd.xml");
		
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);
		
		transformer.transform(source, console);
		transformer.transform(source, file);

}
	
	private static Node[] createUser(Document doc) throws ParserConfigurationException, SAXException, IOException{
		
		File file = new File("usersh46lpd.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();         
        Document doc2 = db.parse(file); 
        doc2.getDocumentElement().normalize();
        
            
        NodeList nodeList = doc2.getElementsByTagName("user");
        
        Element[] users = new Element[nodeList.getLength()];
            
        for (int i = 0; i < nodeList.getLength(); i++) {
        	Node node = nodeList.item(i);
        	users[i] = doc.createElement("user");
        	if (node.getNodeType() == Node.ELEMENT_NODE)
            {
        		Element element = (Element)node;
                users[i].setAttribute("id", element.getAttribute("id"));
                users[i].appendChild(createUserElement(doc, "firstname", element.getElementsByTagName("firstname").item(0).getTextContent()));
                users[i].appendChild(createUserElement(doc, "lastName", element.getElementsByTagName("lastname").item(0).getTextContent()));
                users[i].appendChild(createUserElement(doc, "profession", element.getElementsByTagName("profession").item(0).getTextContent()));
            }
        }
		
		return users;
    }

    private static Node createUserElement(Document doc, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}

package xpathh46lpd1109;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class xPathh46lpd {

	public static void main(String[] args) {
		try{
            //File xmlFile = new File("class.xml");

            //Document builder létrehozása
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse("studenth46lpd.xml");
            
            document.getDocumentElement().normalize();

            //Az xPath készítése
            XPath xPath = XPathFactory.newInstance().newXPath();

            //Meg kell adni az elérési út kifejezést és a csomópont listát.
           
            //String expression = "class";
            String expression = getExpression(1);

            //Készítsünk egy listát, majd a Path kifejezést meg kell írni és ki kelll értékelni
            NodeList nl = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            //A for ciklus segítségével a NodeList csomópontjait végig kell iterálni.
            for(int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);

                System.out.println("\nAktuális elem: " + node.getNodeName());
                
              //Meg kell vizsgálni a csomópontot, az subelement tesztelése megtörtént
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
                    Element element = (Element) node;

                    //az id attribútumot ad vissza
                    System.out.println("Hallgató ID: " + element.getAttribute("id"));
                    
                    //keresztnevet ad vissza
                    System.out.println("Keresztnév: " + element.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Vezetéknév: " + element.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("Becenév: " + element.getElementsByTagName("nickName").item(0).getTextContent());
                    System.out.println("Kor: " + element.getElementsByTagName("age").item(0).getTextContent());
                }
            }    
        } catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch(SAXException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(XPathExpressionException e){
            e.printStackTrace();
        }

	}
	
	private static String getExpression(int number) {
        switch (number) {
            case 0: return "class";
            case 1: return "class/student";
            case 2: return "class/student[@id='01']";
            case 3: return "//student";
            case 4: return "class/student[2]";
            case 5: return "class/student[last()]";
            case 6: return "class/student[last()-1]";
            case 7: return "class/student[position()<3]";
            case 8: return "class/*";
            case 9: return "//student[@*]";
            case 10: return "*";
            case 11: return "class/student[kor>20]";
            case 12: return "//student/keresztnev | //student/vezeteknev";
            default: return "";
        }
    }

}

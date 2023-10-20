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

            //Document builder l�trehoz�sa
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse("studenth46lpd.xml");
            
            document.getDocumentElement().normalize();

            //Az xPath k�sz�t�se
            XPath xPath = XPathFactory.newInstance().newXPath();

            //Meg kell adni az el�r�si �t kifejez�st �s a csom�pont list�t.
           
            //String expression = "class";
            String expression = getExpression(1);

            //K�sz�ts�nk egy list�t, majd a Path kifejez�st meg kell �rni �s ki kelll �rt�kelni
            NodeList nl = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            //A for ciklus seg�ts�g�vel a NodeList csom�pontjait v�gig kell iter�lni.
            for(int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);

                System.out.println("\nAktu�lis elem: " + node.getNodeName());
                
              //Meg kell vizsg�lni a csom�pontot, az subelement tesztel�se megt�rt�nt
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
                    Element element = (Element) node;

                    //az id attrib�tumot ad vissza
                    System.out.println("Hallgat� ID: " + element.getAttribute("id"));
                    
                    //keresztnevet ad vissza
                    System.out.println("Keresztn�v: " + element.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Vezet�kn�v: " + element.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("Becen�v: " + element.getElementsByTagName("nickName").item(0).getTextContent());
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

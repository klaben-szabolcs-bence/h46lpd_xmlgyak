package hu.domparse.h46lpd;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomReadH46LPD {

  public static void main(String[] args) throws ParserConfigurationException, IOException {
    File file = new File("XMLH46LPD.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = factory.newDocumentBuilder();
    Document doc = dBuilder.parse(file);
    doc.getDocumentElement().normalize();
    System.out.println("Root elem: " + doc.getDocumentElement().getNodeName());
    
    System.out.println("Oktatok:");
    NodeList nList = doc.getElementsByTagName("oktato");
    for (int i = 0; i < nList.getLength(); i++) {
      Node node = nList.item(i);
      if (node.getNodeType() != Node.ELEMENT_NODE) return;
      Element elem = (Element)node;
      System.out.println("\tOktato Neptunkod: " + elem.getAttribute("neptunkod"));
      System.out.println("\t\tNev: " + elem.getElementsByTagName("nev").item(0).getTextContent());
      System.out.println("\t\tTanszek: " + elem.getElementsByTagName("tanszek").item(0).getTextContent());
      System.out.println("\t\tTargy: " + elem.getElementsByTagName("targy").item(0).getTextContent());
    }
    
    System.out.println("Targyak:");
    NodeList nList = doc.getElementsByTagName("targy");
    for (int i = 0; i < nList.getLength(); i++) {
      Node node = nList.item(i);
      if (node.getNodeType() != Node.ELEMENT_NODE) return;
      Element elem = (Element)node;
      System.out.println("\tTargy kod: " + elem.getAttribute("kod"));
      System.out.println("\t\tKredit: " + elem.getElementsByTagName("kredit").item(0).getTextContent());
      System.out.println("\t\tMegnev: " + elem.getElementsByTagName("megnev").item(0).getTextContent());
    }
    
    System.out.println("Hallgatasok:");
    NodeList nList = doc.getElementsByTagName("hallgatas");
    for (int i = 0; i < nList.getLength(); i++) {
      Node node = nList.item(i);
      if (node.getNodeType() != Node.ELEMENT_NODE) return;
      Element elem = (Element)node;
      System.out.println("\t\tTargy: " + elem.getElementsByTagName("targy").item(0).getTextContent());
      System.out.println("\t\tHallgato: " + elem.getElementsByTagName("hallgato").item(0).getTextContent());
      System.out.println("\t\tFelev: " + elem.getElementsByTagName("felev").item(0).getTextContent());
      System.out.println("\t\tVizsgajegy: " + elem.getElementsByTagName("vizsgajegy").item(0).getTextContent());
      
    }
    System.out.println("Hallgatok:");
    NodeList nList = doc.getElementsByTagName("hallgato");
    for (int i = 0; i < nList.getLength(); i++) {
      Node node = nList.item(i);
      if (node.getNodeType() != Node.ELEMENT_NODE) return;
      Element elem = (Element)node;
      System.out.println("\tHallgato Neptunkod: " + elem.getAttribute("neptunkod"));
      System.out.println("\t\tNev: " + elem.getElementsByTagName("nev").item(0).getTextContent());
      System.out.println("\t\tTanskor: " + elem.getElementsByTagName("tankor").item(0).getTextContent());
      System.out.println("\t\tSzulDat: " + elem.getElementsByTagName("szuldat").item(0).getTextContent());
      System.out.println("\t\tCim:");
      System.out.println("\t\t\tIrszam: " + elem.getElementsByTagName("irszam").item(0).getTextContent());
      System.out.println("\t\t\tVaros: " + elem.getElementsByTagName("varos").item(0).getTextContent());
      System.out.println("\t\t\tUtca: " + elem.getElementsByTagName("utca").item(0).getTextContent());
      System.out.println("\t\t\tHazszam: " + elem.getElementsByTagName("hazszam").item(0).getTextContent());
      
    }
    
  }
}

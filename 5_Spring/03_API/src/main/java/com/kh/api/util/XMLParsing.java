package com.kh.api.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void main(String[] args) {
	
		String serviceKey="OA%2BSL7ZlXt65YirQBc9DoC8I3C5f%2BfTs2y%2FsenvKTfOvBt5jugZylNr8jTexsSnw7S%2B7M1GhY6up4DKYkcg%2BwQ%3D%3D";
		String url="https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey="+ serviceKey +"&numOfRows=396";
		
		
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);  // import org.w3c.dom.Document; import !!
			
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName()); // 최상단 태그 
			
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println(nList.getLength());
			
			for(int i=0; i< nList.getLength(); i++) {
				Node nNode = nList.item(i); // import org.w3c.dom import
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement =(Element) nNode;
					
					System.out.println("MAIN_TITLE :" + getTagValue("MAIN_TITLE",eElement));
					System.out.println("ADDR1 : " + getTagValue("ADDR1", eElement).trim());
					System.out.println("------------------------------------------------------");
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	public static String getTagValue(String tag, Element eElement) {
		
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if(nValue == null) return null;
		return nValue.getNodeValue();
				
	
	}
	
}

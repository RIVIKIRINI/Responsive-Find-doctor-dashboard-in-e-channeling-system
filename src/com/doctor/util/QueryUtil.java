package com.doctor.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil {

    public static String queryById(String id) throws SAXException, IOException, ParserConfigurationException {

        NodeList nodeList;
        Element element = null;

        String filePath = System.getProperty("catalina.base") + "\\wtpwebapps\\find-a-doctor\\WEB-INF\\queries.xml";
        File xmlFile = new File(filePath);

        if (!xmlFile.exists()) {
            throw new IOException("XML file not found at the specified location");
        }

        nodeList = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(xmlFile)
                .getElementsByTagName(CommonConstants.TAG_NAME);

        for (int value = 0; value < nodeList.getLength(); value++) {
            element = (Element) nodeList.item(value);
            if (element.getAttribute(CommonConstants.ATTRIB_NAME).equals(id)) {
                break;
            }
        }

        if (element != null) {
            return element.getTextContent().trim();
        } else {
            throw new IllegalArgumentException("No element found with the given ID");
        }
    }
    
   
}

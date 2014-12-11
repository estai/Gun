package com.epam.parser;

import com.epam.entity.Gun;
import com.epam.entity.Handy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

/**
 * Created by User on 29.11.14.
 */
public class DomXMLEntityParser implements XMLEntityParser {
    @Override
    public Gun parserGun(InputStream stream) {
     Gun gun=null;
        Document document;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
           document=builder.parse(stream);
            Element root=document.getDocumentElement();
            NodeList list=root.getElementsByTagName("ns0:gun");
            gun=this.gunBuild(list);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return gun;
    }
    private Gun gunBuild(NodeList list){
        Gun gun=new Gun();
        for (int i = 0; i < list.getLength(); i++) {
        Element element=(Element)list.item(i);
        this.setValue("ns0:ID",element,gun);
            this.setValue("ns0:model",element,gun);
            this.setValue("ns0:origin",element,gun);
            this.setValue("ns0:handy",element,gun);
        }
        return gun;
    }
    private void setValue(String elementName,Element element,Gun gun){
        Node n=element.getElementsByTagName(elementName).item(0).getFirstChild();
        switch (elementName){
            case "ns0:ID":gun.setID(new Long(n.getNodeValue())); break;
            case "ns0:model":gun.setModel(n.getNodeValue()); break;
            case "ns0:origin":gun.setOrigin(n.getNodeValue()); break;
            case "ns0:handy" : gun.setHandy(Handy.valueOf(n.getNodeValue().toUpperCase()));
        }
    }
}

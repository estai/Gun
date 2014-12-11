package com.epam.parser;

import com.epam.entity.Gun;
import com.epam.entity.Handy;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StaxXMLEntityParser implements XMLEntityParser {
    private Gun gun;
    @Override
    public Gun parserGun(InputStream stream) {

        String currentElement;
        StringBuilder builder = new StringBuilder();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader=factory.createXMLStreamReader(stream);
            int event;
            while (reader.hasNext()) {
                event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT: gun=new Gun();break;
                    case XMLStreamConstants.START_ELEMENT: currentElement=reader.getLocalName();
                        builder.setLength(0);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (currentElement == null) break;
                        String s = builder.toString().trim();
                        switch (currentElement){
                            case "ID": gun=new Gun(Long.parseLong(s)); break;
                            case "handy": s.toUpperCase(); gun.setHandy(Handy.valueOf(s));break;
                            case "model": gun.setModel(s);break;
                            case "origin": gun.setModel(s);break;
                        }
                        currentElement=null;
                                 break;
                    case XMLStreamConstants.CHARACTERS:builder.append(reader.getText());
                }
            }
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
       return gun;
    }
}

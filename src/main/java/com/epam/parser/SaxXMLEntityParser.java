package com.epam.parser;

import com.epam.entity.Gun;
import com.epam.entity.Handy;
import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;


public class SaxXMLEntityParser implements XMLEntityParser {
 private Gun gun;

    @Override
    public Gun parserGun(InputStream stream) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(stream, new GunDefaultHandler());
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return gun;
    }
    private class GunDefaultHandler extends DefaultHandler {
        private String currentElement;
        private StringBuilder builder = new StringBuilder();
        private Gun gun;

        @Override
        public void startDocument() throws SAXException {

        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            builder.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement == null) return;
            String s = builder.toString().trim();
           switch (currentElement){
                case "ID": gun=new Gun(Long.parseLong(s)); break;
                case "handy": s.toUpperCase(); gun.setHandy(Handy.valueOf(s));break;
                case "model": gun.setModel(s);break;
                case "origin": gun.setModel(s);break;
            }
            currentElement=null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            builder.append(ch, start, length);
        }
    }

}

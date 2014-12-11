package com.epam;

import com.epam.entity.Gun;
import com.epam.parser.DomXMLEntityParser;
import com.epam.parser.JaxbXmlEntityParser;
import com.epam.parser.XMLEntityParser;

import java.io.InputStream;

/**
 * Created by User on 29.11.14.
 */
public class Runner {
    public static void main(String[] args) {

        InputStream stream = Runner.class.getClassLoader().getResourceAsStream("Gun.xml");

        XMLEntityParser parser = new DomXMLEntityParser();

        Gun gun = parser.parserGun(stream);

        System.out.println(gun);

    }
}

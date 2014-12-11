package com.epam.parser;


import com.epam.entity.Gun;

import java.io.InputStream;

public interface XMLEntityParser {
   public Gun parserGun(InputStream stream);
}

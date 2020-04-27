package com.appareldiving.dataretriever.util;

import com.appareldiving.dataretriever.parser.ParserEnum;

public class ParserUtil {

    public static boolean containsParser(String parser)
    {
        for (ParserEnum value : ParserEnum.values()) {
            if( value.getName().equals(parser) )
            {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

}

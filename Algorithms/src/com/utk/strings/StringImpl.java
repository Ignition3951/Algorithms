package com.utk.strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringImpl {

    private static final Logger LOGGER = Logger.getLogger(StringImpl.class.getName());

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        LOGGER.log(Level.INFO, "The char array is : {0}", StringUtility.removeOuterParenthesis(s));
    }
}

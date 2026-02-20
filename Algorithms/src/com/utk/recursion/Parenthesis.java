package com.utk.recursion;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    private static final List<String> RESULT=new ArrayList<>();

    static void main() {
        RESULT.clear();
        generateParenthesis("",0,0,1);
        for(String str: RESULT){
            System.out.println(str+ " ");
        }
    }

    static void generateParenthesis(String str,int obCounter,int cbCounter,int length) {
        if(obCounter == length && cbCounter == length){
            RESULT.add(str);
            return;
        }

        if(obCounter < length){
            generateParenthesis(str+"(",obCounter+1,cbCounter,length);
        }

        if(cbCounter < length && cbCounter < obCounter){
            generateParenthesis(str+")",obCounter,cbCounter+1,length);
        }
    }
}

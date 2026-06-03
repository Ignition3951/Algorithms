package com.utk.recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryString {

    private static final List<String> result = new ArrayList<>();
    private static final int GENERATION_LENGTH = 3;

    static void main() {

        for(String str: backtrack()){
            System.out.println(str + " ");
        }
    }

    static List<String> backtrack(){
        result.clear();
        generateBinaryString("",GENERATION_LENGTH,'0');
        return result;
    }

    static void generateBinaryString(String str, int length, char ch) {
        if (str.length() == length) {
            result.add(str);
            return;
        }

        generateBinaryString(str + "0", length, '0');
        if (ch != '1') {
            generateBinaryString(str + "1", length, '1');
        }

    }
}

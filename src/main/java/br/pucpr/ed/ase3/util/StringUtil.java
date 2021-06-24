package br.pucpr.ed.ase3.util;

public class StringUtil {
    public static String lpad(String inputString, int pad){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pad; i++) {
            sb.append(' ');
        }

        return sb.substring(inputString.length()) + inputString;
    }
}

package com.example.jhon.listas;

/**
 * Created by jhon on 16/09/16.
 */
public class ValidateStrings {

    public static boolean validateStringsInEditText(String...params){

        for (String param : params) {
            if (param.startsWith(" ")){
                return false;
            }
        }
        return true;
    }
}

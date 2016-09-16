package com.example.jhon.listas.util;

import com.example.jhon.listas.Models.Postres;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhon on 16/09/16.
 */
public class Util {
    private static List<Postres> data;
    public static List<Postres> getData(){
        if (data == null){
            data = new ArrayList<>();
        }
        return data;
    }
}

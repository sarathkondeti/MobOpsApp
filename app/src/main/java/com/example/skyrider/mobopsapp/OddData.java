package com.example.skyrider.mobopsapp;

import java.util.ArrayList;

/**
 * Created by skyrider on 22/5/17.
 */

public class OddData {
    public static ArrayList<Information> getData(){

        ArrayList<Information> data = new ArrayList<>();



        for (int i = 1; i <= 50; i++) {
            Information current = new Information();

            current.no = (2*i-1);
            data.add(current);
        }


        return data;
    }
}

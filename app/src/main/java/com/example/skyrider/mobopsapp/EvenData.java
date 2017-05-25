package com.example.skyrider.mobopsapp;

import java.util.ArrayList;

/**
 * Created by skyrider on 22/5/17.
 */

public class EvenData {
    public static ArrayList<Information> getData(){

        ArrayList<Information> data = new ArrayList<>();



        for (int i = 1; i <= 50; i++) {
            Information current = new Information();

            current.no = (2*i);
            data.add(current);
        }


        return data;
    }
}

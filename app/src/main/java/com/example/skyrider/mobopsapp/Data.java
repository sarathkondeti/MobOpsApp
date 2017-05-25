package com.example.skyrider.mobopsapp;

import java.util.ArrayList;

/**
 * Created by skyrider on 21/5/17.
 */

public class Data {


    public static ArrayList<Information> getData(){

        ArrayList<Information> data = new ArrayList<>();



            for (int i = 1; i <= 100; i++) {
                Information current = new Information();

                current.no = i;
                data.add(current);
            }


        return data;
    }


}


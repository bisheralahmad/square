package com.test.myapplication;

public class MainContract {


    interface View {
        /**prints the square data on the screen*/

        void printSquare(String result);
    }

    interface Presenter{

        /**calculates the square data */
        void calculateSquare(int n);
    }
}

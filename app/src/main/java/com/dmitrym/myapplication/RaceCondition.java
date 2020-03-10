package com.dmitrym.myapplication;

public class RaceCondition {
    static class Incrementer {
        int i = 0;

        void act() {
            for (int j = 0; j < 10; j++) {
                System.out.println("Current number " +  i++);
            }
        }
    }
}

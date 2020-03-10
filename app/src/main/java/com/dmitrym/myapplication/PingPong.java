package com.dmitrym.myapplication;

public class PingPong {

    synchronized void ping(PingPong pingPong) {
        System.out.println("ping");
        pingPong.pong(this);
    }

    synchronized void pong(PingPong pingPong) {
        System.out.println("pong");
        pingPong.ping(this);
    }
}

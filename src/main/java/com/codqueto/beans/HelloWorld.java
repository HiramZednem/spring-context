package com.codqueto.beans;

public class HelloWorld {
    private String greeting;


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}

package com.example.httpserver.utils;

public class Command {

    int portNumber;
    public boolean isValid(String[] args) {
        if(args.length!=2) return false;
        if(!args[0].equals("-port")) return false;
        this.portNumber = Integer.parseInt(args[1]);
        return true;
    }

    public int getPortNumber(){ return portNumber;}
}

package classes;

import enums.*;
import classes.*;
import interfaces.*;
import exceptions.*;


public record Place(String name) {

    public String toString(){
        return this.name;
    }
}
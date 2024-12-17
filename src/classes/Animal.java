package classes;

import java.util.Date;
import enums.*;
import classes.*;
import interfaces.*;
import exceptions.*;

public class Animal extends Creature {

    public Animal(String name) {
        super(name, TypeOfCreature.ANIMAL);
    }

    @Override
    public void look(){
        this.setState(State.LOOK);
        System.out.println(this.getName() + ' ' + this.getState());
    }

    @Override
    public void thinking(Degree degree) {
        this.setState(State.THINK);
        System.out.println(this.getName() + ' ' + degree.toString() + ' ' + this.getState().toString());
    }

    @Override
    public void nod(){
        this.setState(State.NOD);
        System.out.println(this.getName() + ' ' + this.getState().toString());
    }

    @Override
    public int hashCode() {
        Date date = new Date();
        int result = (int)date.getTime();
        result += this.getName().hashCode();
        result *= this.getTypeOfCreature().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

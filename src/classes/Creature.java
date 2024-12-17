package classes;

import enums.*;
import interfaces.*;
import exceptions.*;

public abstract class Creature implements Handshakeable, Gameable, Walkingable {
    private final String name;
    private final TypeOfCreature typeOfCreature;
    private State state = State.NONE;
    private Type type = Type.ORDER;

    public Creature(String name, TypeOfCreature typeOfCreature) {
        this.name = name;
        this.typeOfCreature = typeOfCreature;
    }

    abstract void look();

    abstract void thinking(Degree degree);

    abstract void nod();

    public void setType(Type type){
        this.type = type;
    }

    public Type getType(){
        return type;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public String getName() {
        return name;
    }

    public TypeOfCreature getTypeOfCreature() {
        return typeOfCreature;
    }

    @Override
    public void handshake(Creature other) {
        this.setState(State.GREET);
        String result = this.getName() + " жмёт ";
        if (other.getTypeOfCreature() == TypeOfCreature.HUMAN)
            result += "руку";
        else
            result += "лапу";
        result += " " + other.getName();
        System.out.println(result);
    }

    @Override
    public void game(Creature other, Place... places) {
        this.setState(State.PLAY);
        System.out.print(this.getName() + " играет с " + other.getName() + " на ");
        for (Place elem : places) {
            System.out.print(elem.toString() + ' ');
        }
        System.out.println();
    }

    @Override
    public void walking(Creature other, Place... places) {
        this.setState(State.WALK);
        System.out.print(this.getName() + " идёт вместе с " + other.getName() + ' ');
        for (Place elem : places) {
            System.out.print(elem.toString() + ' ');
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return this.getTypeOfCreature().toString() + ' ' + this.getType() + ' ' + this.getName();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        if (this == obj){
            return true;
        }
        Creature tmp = (Creature) obj;
        if (this.getName().equals(tmp.getName()) && this.getTypeOfCreature() == tmp.getTypeOfCreature())
            return true;
        return false;
    }
}
public abstract class Creature implements Handshakeable, Gameable, Walkingable {
    private final String name;
    private final TypeOfCreature typeOfCreature;
    private State state = State.NONE;

    Creature(String name, TypeOfCreature typeOfCreature) {
        this.name = name;
        this.typeOfCreature = typeOfCreature;
    }

    abstract void thinking();

    abstract void nod();

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
}
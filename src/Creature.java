public abstract class Creature implements Handshakeable, Gameable, Walkingable {
    private final String name;
    private final TypeOfCreature typeOfCreature;

    Creature(String name, TypeOfCreature typeOfCreature) {
        this.name = name;
        this.typeOfCreature = typeOfCreature;
    }

    public String getName() {
        return name;
    }

    public TypeOfCreature getTypeOfCreature() {
        return typeOfCreature;
    }

    @Override
    public void handshakeable(Creature other) {
        String result = this.getName() + " жмёт ";
        if (other.getTypeOfCreature() == TypeOfCreature.HUMAN)
            result += "руку";
        else
            result += "лапу";
        result += " " + other.getName();
        System.out.println(result);
    }

    @Override
    public void gameable(Creature other, Place ... places) {
        System.out.print(this.getName() + " играет с " + other.getName() + " на ");
        for (Place elem: places){
            System.out.print(elem.toString() + ' ');
        }
        System.out.println();
    }

    @Override
    public void walkingable(Creature other, Place ... places) {
        System.out.print(this.getName() + " идёт вместе с " + other.getName() + ' ');
        for (Place elem: places){
            System.out.print(elem.toString() + ' ');
        }
        System.out.println();
    }
}
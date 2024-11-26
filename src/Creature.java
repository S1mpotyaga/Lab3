public abstract class Creature implements Handshake, Game, Walking {
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
    public void Handshake(Creature other) {
        String result = this.getName() + " жмёт ";
        if (other.getTypeOfCreature() == TypeOfCreature.HUMAN)
            result += "руку";
        else
            result += "лапу";
        result += " " + other.getName();
        System.out.println(result);
    }

    @Override
    public void Game(Creature other) {
        System.out.println(this.getName() + " играет с " + other.getName());
    }

    @Override
    public void Walking(Creature other) {
        System.out.println(this.getName() + " идёт вместе с " + other.getName());
    }
}
import java.util.ArrayList;

public class Human extends Creature {
    private Family family;
    private ArrayList<Place> places;

    Human(String name) {
        super(name, TypeOfCreature.HUMAN);
    }

    public void addPlaces(Place... args) {
        try {
            for (Place elem : args) {
                places.add(elem);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Нечего добавлять!!!");
            System.exit(-1);
        }
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getSurname() {
        try {
            return family.getSurname();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(-100);
            return "";
        }
    }

    @Override
    public int hashCode() {
        final int MOD = (int) 1e9 + 7;
        String name = super.getName();
        long result = name.hashCode();
        result = (result * getTypeOfCreature().hashCode()) % MOD;
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        Creature tmp = (Creature) obj;
        return hashCode() == tmp.hashCode();
    }

    @Override
    public String toString() {
        return "Человек " + super.getName();
    }
}
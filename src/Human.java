import java.util.ArrayList;
import java.util.Date;

public class Human extends Creature {
    private Family family;
    private ArrayList<Place> places;

    Human(String name) {
        super(name, TypeOfCreature.HUMAN);
    }

    @Override
    public void thinking() {
        this.setState(State.THINK);
        System.out.println(this.getName() + this.getState().toString());
    }

    @Override
    public void nod() {
        this.setState(State.NOD);
        System.out.println(this.getName() + this.getState().toString());
    }

    public void setPlaces(Place... args) {
        this.places = new ArrayList<Place>();
        for (Place place : args) {
            places.add(place);
        }
    }

    public void addPlaces(Place... args) {
        try {
            for (Place elem : args) {
                places.add(elem);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Некуда добавлять!");
            System.exit(-1);
        }
    }

    public ArrayList<Place> getPlaces() throws NullPointerException {
        return places;
    }

    public Family getFamily() {
        return family;
    }

    public String where() throws NullPointerException {
        String result = this.getName() + " здесь: ";
        for (Place elem : this.places) {
            result += elem.toString() + ' ';
        }
        return result;
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
        Date date = new Date();
        int result = (int)date.getTime();
        result += this.getName().hashCode() + this.getTypeOfCreature().hashCode();
        for (Place place: places){
            result += place.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        if (this == obj){
            return true;
        }
        Human tmp = (Human) obj;
        if (this.family.equals(tmp.getFamily()) && this.getPlaces().equals(tmp.getPlaces())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() throws NullPointerException {
        String result = this.getTypeOfCreature().toString() + super.getName() + ' ';
        for (Place elem : places) {
            result += elem.toString();
        }
        return result;
    }
}
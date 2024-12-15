import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Family {
    private ArrayList<Creature> family = new ArrayList<Creature>();
    private ArrayList<Relative> relatives = new ArrayList<Relative>();
    private ArrayList<Place> placesOfResidence = new ArrayList<Place>();
    private final String surname;
    private final String nation;

    Family(String surname, Creature creature) {
        this.surname = surname;
        this.nation = "";
        this.family.add(creature);
        relatives.add(Relative.ALONE);
    }

    Family(String surname, String nation) {
        this.surname = surname;
        this.nation = nation;
        this.family = new ArrayList<Creature>();
        this.relatives = new ArrayList<Relative>();
        this.placesOfResidence = new ArrayList<>();
    }

    public void setFather(Creature father) throws ParentsException {
        for (Relative elem: relatives){
            if (elem == Relative.FATHER)
                throw new ParentsException();
        }
        family.add(father);
        relatives.add(Relative.FATHER);
    }

    public void setMother(Creature mother) throws ParentsException{
        for (Relative elem: relatives){
            if (elem == Relative.MOTHER){
                throw new ParentsException();
            }
        }
        family.add(mother);
        relatives.add(Relative.MOTHER);
    }

    public void setSons(Creature... sons) {
        for (Creature human : sons) {
            family.add(human);
            relatives.add(Relative.SON);
        }
    }

    public void setDuaghters(Creature... duaghters) {
        for (Creature creature : duaghters) {
            family.add(creature);
            relatives.add(Relative.DUAGHTER);
        }
    }

    public void addPlaces(Place ... places){
        for (Place elem: places){
            placesOfResidence.add(elem);
        }
    }

    public ArrayList<Place> getPlacesOfResidence(){
        return this.placesOfResidence;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Creature> getFamily() {
        return family;
    }

    public void addFamily(Creature human, Relative relative) {
        family.add(human);
        relatives.add(relative);
    }

    public String getNation() {
        return nation;
    }

    @Override
    public int hashCode() {
        Date date = new Date();
        int result = (int)date.getTime();
        result += this.surname.hashCode() + this.nation.hashCode();
        for (Place place: placesOfResidence){
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
        Family tmp = (Family) obj;
        if (this.family.equals(tmp.getFamily()) && this.placesOfResidence.equals(((Family) obj).getPlacesOfResidence())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getNation() + " cемья " + getSurname() + ": ");
        for (int i = 0; i < family.size(); ++i) {
            result.append(relatives.get(i)).append(' ');
            result.append(family.get(i).getName()).append(' ');
        }
        result.append(" живет в ");
        for (Place elem: placesOfResidence){
            result.append(elem.toString()).append(" ");
        }
        return result.toString();
    }
}
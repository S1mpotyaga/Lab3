import java.util.ArrayList;

public class Family {
    private ArrayList<Creature> family;
    private ArrayList<Relative> relatives;
    private final String surname;
    private final String nation;

    Family(String surname, Creature creature) {
        this.surname = surname;
        this.nation = "";
        family.add(creature);
        relatives.add(Relative.ALONE);
    }

    Family(String surname, String nation) {
        this.surname = surname;
        this.nation = nation;
        this.family = new ArrayList<Creature>();
        this.relatives = new ArrayList<Relative>();
    }

    public void setFather(Human human) {
        family.add(human);
        relatives.add(Relative.FATHER);
    }

    public void setMother(Human human) {
        family.add(human);
        relatives.add(Relative.MOTHER);
    }

    public void setSons(Human... sons) {
        for (Human human : sons) {
            family.add(human);
            relatives.add(Relative.SON);
        }
    }

    public void setDuaghter(Human... duaghters) {
        for (Human human : duaghters) {
            family.add(human);
            relatives.add(Relative.DUAGHTER);
        }
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
        long result = 0;
        final int MOD = (int) 1e9 + 7;
        for (Creature creature : family)
            result = (result + creature.getName().hashCode()) % MOD;
        result = result * getSurname().hashCode() % MOD;
        result = result * (getNation().equals("") ? 1 : getNation().hashCode() % MOD);
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        Family other = (Family) obj;
        return hashCode() == other.hashCode();
    }

    @Override
    public String toString() {
        String result = getNation() + " cемья " + getSurname() + ": ";
        for (int i = 0; i < family.size(); ++i) {
            if (relatives.get(i) == Relative.FATHER) {
                result += "отец ";
            } else if (relatives.get(i) == Relative.MOTHER)
                result += "мать ";
            else if (relatives.get(i) == Relative.DUAGHTER)
                result += "дочь ";
            else
                result += "сын ";
            result += family.get(i).getName() + ' ';
        }
        return result;
    }
}
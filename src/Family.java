import java.util.ArrayList;

public class Family {
    private ArrayList<Human> family;
    private ArrayList<Relative> relatives;
    private final String surname;
    private final String nation;

    Family(String surname, String nation, ArrayList<Human> family, ArrayList<Relative> relatives) {
        this.surname = surname;
        this.nation = nation;
        this.family.addAll(family);
        this.relatives.addAll(relatives);
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Human> getFamily() {
        return family;
    }

    public void addFamily(Human human, Relative relative) {
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
        for (Human human : family)
            result = (result + human.getName().hashCode()) % MOD;
        result = result * getSurname().hashCode() % MOD;
        result = result * getNation().hashCode() % MOD;
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
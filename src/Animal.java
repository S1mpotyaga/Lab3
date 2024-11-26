public class Animal extends Creature {
    Animal(String name) {
        super(name, TypeOfCreature.ANIMAL);
    }

    @Override
    public int hashCode() {
        final int MOD = (int) 1e9 + 7;
        String name = super.getName();
        long result = 0;
        for (int i = 0; i < name.length(); ++i) {
            result = (result * 31 % MOD + name.charAt(i)) % MOD;
        }
        result = (result * getTypeOfCreature().hashCode()) % MOD;
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        Creature tmp = (Creature) obj;
        if (super.getName().equals(tmp.getName()) && super.getTypeOfCreature() == tmp.getTypeOfCreature())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Животное " + super.getName();
    }
}

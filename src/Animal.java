import java.util.Date;

public class Animal extends Creature {

    Animal(String name) {
        super(name, TypeOfCreature.ANIMAL);
    }

    @Override
    public void thinking(){
        this.setState(State.THINK);
        System.out.println(this.getName() + ' ' + this.getState().toString());
    }

    @Override
    public void nod(){
        this.setState(State.NOD);
        System.out.println(this.getName() + ' ' + this.getState().toString());
    }

    @Override
    public int hashCode() {
        Date date = new Date();
        int result = (int)date.getTime();
        result += this.getName().hashCode();
        result *= this.getTypeOfCreature().hashCode();
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
        Creature tmp = (Creature) obj;
        if (super.getName().equals(tmp.getName()) && super.getTypeOfCreature() == tmp.getTypeOfCreature())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.getTypeOfCreature().toString() + super.getName();
    }
}

package enums;


public enum TypeOfCreature {
    HUMAN("человек"),
    ANIMAL("животное");

    private String typeOfCreature;

    private TypeOfCreature(String typeOfCreature){
        this.typeOfCreature = typeOfCreature;
    }

    @Override
    public String toString(){
        return typeOfCreature;
    }
}

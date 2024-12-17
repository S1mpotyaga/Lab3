package enums;

public enum Type {
    ORDER("обыкновенный"),
    UNORDER("необыкновенный");

    private String type;

    private Type(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}

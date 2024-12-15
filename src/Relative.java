public enum Relative {
    FATHER("отец"),
    MOTHER("мать"),
    DUAGHTER("дочь"),
    SON("сын"),
    ALONE("одиночка");

    private String relative;

    private Relative(String relative){
        this.relative = relative;
    }

    @Override
    public String toString(){
        return relative;
    }
}

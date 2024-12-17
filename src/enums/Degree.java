package enums;

public enum Degree {
    STRONG("сильно"),
    AVG("средне"),
    WEAKLY("слабо");

    private String degree;

    private Degree(String degree){
        this.degree = degree;
    }

    @Override
    public String toString(){
        return degree;
    }
}

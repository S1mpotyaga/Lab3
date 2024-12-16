package enums;


public enum State {
    THINK("думает"),
    PLAY("играет"),
    WALK("идет"),
    GREET("здоровается"),
    NOD("кивает"),
    NONE("бездельничает");

    private String state;

    private State(String state){
        this.state = state;
    }

    @Override
    public String toString(){
        return state;
    }
}

public class ParentsException extends Exception{

    public String getMessage(){
        return "Error! Не может быть двух одинаковых родителя в семье!";
    }
}
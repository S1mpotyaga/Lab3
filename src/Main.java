import enums.*;
import classes.*;
import interfaces.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        Animal vinni = new Animal("Винни");
        Family puch = new Family("Пух", vinni);

        Degree degreeThinkingVinni = Degree.AVG;

        vinni.thinking(degreeThinkingVinni);
        vinni.nod();
        vinni.look();

        Human kristofer = new Human("Кристофер");
        Family robin = new Family("Робин", kristofer);

        kristofer.handshake(vinni);

        Place somewhere = new Place("Где-то");
        Place enchantedPlace = new Place("Зачарованное место");
        Place TopOfHill = new Place("Вершина холма");
        Place Forest = new Place("Лес");

        kristofer.walking(vinni, somewhere);
        kristofer.walking(vinni, enchantedPlace, TopOfHill, Forest);
        try {
            kristofer.where();
        } catch (NullPointerException e) {
            System.out.println("Error! Список мест не инициализирован.");
        }
        kristofer.game(vinni, enchantedPlace, TopOfHill, Forest);

        Place stocgholm = new Place("Стокгольм");
        Place OrderStreet = new Place("Обыкновенная улица");
        Place OrderHouse = new Place("Обыкновенный дом");

        Family sventonson = new Family("Свантенсон", "Шведы");
        sventonson.addPlaces(stocgholm, OrderStreet, OrderHouse);
        Human Father = new Human("Папа");
        Human Mother = new Human("Мама");
        Human Bosse = new Human("Боссе");
        Human Betan = new Human("Бетан");
        Human Baby = new Human("Малыш");

        try {
            sventonson.setFather(Father);
        } catch (ParentsException e) {
            System.out.println(e.getMessage());
        }

        try {
            sventonson.setFather(Father);
        } catch (ParentsException e) {
            System.out.println(e.getMessage());
        }
        try {
            sventonson.setMother(Mother);
        } catch (ParentsException e) {
            System.out.println(e.getMessage());
        }
        sventonson.setDuaghters(Bosse, Betan);
        sventonson.setSons(Baby);

        System.out.println(sventonson.toString());
    }
}
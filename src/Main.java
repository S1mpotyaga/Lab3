public class Main {
    public static void main(String[] args) {
        Animal Vinni = new Animal("Винни");
        Family Puch = new Family("Пух", Vinni);

        Vinni.thinking();
        Vinni.nod();

        Human Kristofer = new Human("Кристофер");
        Family Robin = new Family("Робин", Kristofer);

        Place Somewhere = new Place("Где-то");
        Place EnchantedPlace = new Place("Зачарованное место");
        Place TopOfHill = new Place("Вершина холма");
        Place Forest = new Place("Лес");

        Kristofer.walkingable(Vinni, Somewhere);
        Kristofer.walkingable(Vinni, EnchantedPlace, TopOfHill, Forest);
        Kristofer.gameable(Vinni, EnchantedPlace, TopOfHill, Forest);

        Place Stocgholm = new Place("Стокгольм");
        Place OrderStreet = new Place("Обыкновенная улица");
        Place OrderHouse = new Place("Обыкновенный дом");

        Family Sventonson = new Family("Свантенсон", "Шведы");
        Sventonson.addPlaces(Stocgholm, OrderStreet, OrderHouse);
        Human Father = new Human("Папа");
        Human Mother = new Human("Мама");
        Human Bosse = new Human("Боссе");
        Human Betan = new Human("Бетан");
        Human Baby = new Human("Малыш");

        Sventonson.setFather(Father);
        Sventonson.setMother(Mother);
        Sventonson.setDuaghters(Bosse, Betan);
        Sventonson.setSons(Baby);

        System.out.println(Sventonson.toString());
    }
}
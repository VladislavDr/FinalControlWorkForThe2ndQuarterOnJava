
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyStore {
    public static List<Toy> TOY_LIST = new ArrayList<>();
    public static List<Toy> CHOOSING_TOY = new ArrayList<>();
    public static int COUNT_CHOOSING_TOY = 10;
    public static List<Toy> toyStore(){
        TOY_LIST.add(new Toy(01, "Beer", 3, 10));
        TOY_LIST.add(new Toy(02, "Robot", 2, 20));
//        TOY_LIST.add(new Toy(03, "Mouse", 10, 70));
//        TOY_LIST.add(new Toy(04, "Car", 5, 40));
        TOY_LIST.add(new Toy(05, "Duck", 4, 30));
        TOY_LIST.add(new Toy(06, "Puzzle", 2, 10));
        return TOY_LIST;
    }

    public static void show(){
        if(TOY_LIST.isEmpty()){
            System.out.println("Нечего выводить. В магазине закончились игрушки.");
        } else TOY_LIST.forEach(System.out::print);
    }

    public static void remove(Toy toy) {
        if (toy.getCount() > 1) {
            toy.setCount(toy.getCount() - 1);
        } else {
            TOY_LIST.remove(toy);
        }
    }

    public static Toy GetDropChance(){
        Toy temp = null;

        int rnd = GetRandom.rnd();
        for (Toy toy: TOY_LIST) {
            if (toy.getChanceOfFallingOut() > rnd){
                temp = toy;
            }
        }
        if (temp != null){
            remove(temp);
        }
        return temp;
    }
    public static Toy GetMaxDropChance(){
        Toy temp = null;
        Integer maxDropChance = 0;

        for (Toy toy : TOY_LIST) {
            if (toy.getChanceOfFallingOut() > maxDropChance){
                temp = toy;
                maxDropChance = toy.getChanceOfFallingOut();
            }
        }

//        temp.setCount(temp.getCount() - 1);
//        TOY_LIST.removeIf(toy -> toy.getCount() == 0);
        remove(temp);
        return temp;
    }
    public static void AddToy(Toy toy){
        TOY_LIST.add(toy);
    }

    public static List<Toy> ChoosingToy() {

        Toy temp = null;
        if (TOY_LIST.isEmpty()) {
            System.out.println("В магазине не хвататет игрушек для дальнейшего добавления их в подарочный список.");
        } else if (CHOOSING_TOY.size() >= COUNT_CHOOSING_TOY) {
            System.out.println("У вас заполнен список игрушек. Сперва раздарите часть.");
        } else {
                int sizeLst = COUNT_CHOOSING_TOY - CHOOSING_TOY.size();
                for (int i = 0; i < sizeLst; i++) {
                    if(!TOY_LIST.isEmpty()){
                        temp = GetDropChance();
                        if(temp == null){
                            temp = GetMaxDropChance();
                        }
                    } else {
                    System.out.println("У вас закончились игрушки в магазине. Пора добавить новые.");
                    return CHOOSING_TOY;
                }
                CHOOSING_TOY.add(temp);
                }
            }

        System.out.println(CHOOSING_TOY + " - Отобранные игрушки");
        return CHOOSING_TOY;
    }

    public static void GiftToy(List<Toy> toyList){

        try (FileWriter writer = new FileWriter("List of gifts.txt", true)){
            if (!toyList.isEmpty()){
                writer.write(String.valueOf(toyList.get(0)));
                writer.write("\n");
                System.out.println("Успешно подарили " + toyList.get(0));
                toyList.remove(0);
            } else System.out.println("Список подарков пуст. Необходимо его пополнить.");

        }
        catch (IOException e){
            System.out.println("Что-то пошло не так! Игрушку подарить, к сожалению, не удалось :(");
        }
    }
}

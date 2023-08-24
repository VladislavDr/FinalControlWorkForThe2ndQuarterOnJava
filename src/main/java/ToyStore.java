
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    public static List<Toy> TOY_LIST = new ArrayList<>();
    public static List<Toy> CHOOSING_TOY = new ArrayList<>();
    public static int COUNT_CHOOSING_TOY = 10;
    public static List<Toy> toyStore(){
        Toy toy1 = new Toy(01, "Beer", 3, 10);
        Toy toy2 = new Toy(02, "Robot", 2, 20);
        Toy toy3 = new Toy(03, "Mouse", 10, 70);

        TOY_LIST.add(toy1);
        TOY_LIST.add(toy2);
        TOY_LIST.add(toy3);
        TOY_LIST.add(new Toy(04, "Car", 5, 40));
        TOY_LIST.add(new Toy(05, "Duck", 4, 30));
        TOY_LIST.add(new Toy(06, "Puzzle", 2, 10));
        return TOY_LIST;
    }

    public static Toy GetDropChance(){
        Toy temp = null;
        int countToy;

        int rnd = GetRandom.rnd();
        for (Toy toy: TOY_LIST) {
            if (toy.getChanceOfFallingOut() > rnd){
                temp = toy;
            }
        }
        if (temp != null){
            countToy = temp.getCount() - 1;
            temp.setCount(countToy);
            if(temp.getCount() == 0){
                TOY_LIST.remove(temp);
            }
        }
//        TOY_LIST.removeIf(toy -> toy.getCount()==0);
        return temp;
    }
    public static Toy GetMaxDropChance(){
        Toy temp = null;
        Integer maxDropChance = 0;
        int countToy;
        for (Toy toy : TOY_LIST) {
            if (toy.getChanceOfFallingOut() > maxDropChance){
                temp = toy;
                maxDropChance = toy.getChanceOfFallingOut();
            }
        }

        countToy = temp.getCount() - 1;
        temp.setCount(countToy);
        if(temp.getCount() == 0){
            TOY_LIST.remove(temp);
        }
        return temp;
    }
    public static void AddToy(Integer sumID){
        System.out.println("Введите название игрушки, ее количество и шанс выпадения. Вводите все данные через пробел");
        Scanner scanner = new Scanner(System.in);

        try {
            String scanTextUser = scanner.nextLine();
            String[] textUser = scanTextUser.split(" ");
            if (textUser.length != 3){
                System.out.println("Вы ввели не корректные данные");
//                AddToyNotUsed.addToy(sumID);
            } else {
                Integer id = sumID + 1;
                String name = textUser[0];
                Integer count = Integer.valueOf(textUser[1]);
                Integer chanceOfFallingOut = Integer.valueOf(textUser[2]);
                Toy toy = new Toy(id, name, count, chanceOfFallingOut);
                ToyStore.TOY_LIST.add(toy);
                System.out.println("Успешно добавлена игрушка " + toy);
            }
        } catch (NumberFormatException e){
            System.out.println("Данные введены не корректно!");
        }
    }

    public static List<Toy> ChoosingToy() {

        Toy temp = null;
        if (CHOOSING_TOY.size() < COUNT_CHOOSING_TOY){
            if (TOY_LIST.isEmpty()){
                System.out.println("В магазине не хвататет игрушек для дальнейшего добавления их в подарочный список.");
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
        }
        else System.out.println("У вас заполнен список игрушек. Сперва раздарите часть.");

        System.out.println(CHOOSING_TOY + " - Отобранные игрушки");
        return CHOOSING_TOY;
    }
}

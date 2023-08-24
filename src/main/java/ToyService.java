import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ToyService {
    public static void show(){
        if(ToyStore.TOY_LIST.isEmpty()){
            System.out.println("Нечего выводить. В магазине закончились игрушки.");
        } else ToyStore.TOY_LIST.stream().forEach(System.out::print);
    }

    public static void chanceToyChance(){
        System.out.println("Введите id игрушки");
        Scanner scanner = new Scanner(System.in);
        try {
            Integer id = scanner.nextInt();
            for (Toy toy : ToyStore.TOY_LIST) {
                if (toy.getId() == id) {
                    System.out.println("Выбрана игрушка - " + toy);
                    Integer was = toy.getChanceOfFallingOut();
                    System.out.println("Введите новый процент выпадения (число от 1 до 100");
                    Integer became = scanner.nextInt();
                    if (became < 1 || became > 100){
                        throw new IllegalArgumentException("Шанс выпадения не может быть меньше 1 и больше 99");
                    }
                    toy.setChanceOfFallingOut(became);
                    System.out.println("Было " + was + "%. Стало " + became + "%.");
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Данные введены не верно!");
        }
    }

    public static void AddToy() {
        Integer sumID = ToyStore.TOY_LIST.size();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название игрушки");
        String name = scanner.nextLine();

        try {
            System.out.println("Введите количество игрушек на складе (число)");
            Integer quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 1) {
                throw new IllegalArgumentException("Вы ввели не корректные данные. Количество игрушек должно быть положительным числом!");
            }
            Integer id = sumID + 1;

            System.out.println("Введите шанс выпадения игрушки (число от 1 до 100)");
            Integer chanceOfFallingOut = Integer.parseInt(scanner.nextLine());
            if (chanceOfFallingOut < 1 || chanceOfFallingOut > 100)
                throw new IllegalArgumentException("Неверный диапазон числа!");

            Toy toy = new Toy(id, name, quantity, chanceOfFallingOut);
            ToyStore.AddToy(toy);
            System.out.println("Успешно добавлена игрушка " + toy);

        } catch (NumberFormatException e) {
            System.out.println("Данные введены не корректно!");
        }
    }

    public static void giftToy(){
        ToyStore.GiftToy(ToyStore.CHOOSING_TOY);
    }
}

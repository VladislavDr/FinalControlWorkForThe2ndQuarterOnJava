import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PercentageChange {
    public static void chance(List<Toy> toyList){
        System.out.println("Введите id игрушки");
        Scanner scanner = new Scanner(System.in);
        try {
            Integer id = scanner.nextInt();
        for (Toy toy : toyList) {
            if (toy.getId() == id) {
                System.out.println("Выбрана игрушка - " + toy);
                Integer was = toy.getChanceOfFallingOut();
                System.out.println("Введите новый процент выпадения");
                Integer became = scanner.nextInt();
                toy.setChanceOfFallingOut(became);
                System.out.println("Было " + was + "%. Стало " + became + "%.");
            }
        }
        } catch (InputMismatchException e){
            System.out.println("Данные введены не верно!");
        }
    }
}

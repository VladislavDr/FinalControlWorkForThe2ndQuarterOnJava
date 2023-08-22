import java.util.List;
import java.util.Scanner;

public class AddToy {
    public static void addToy( Integer sumID){
        System.out.println("Введите название игрушки, ее количество и шанс выпадения. Вводите все данные через пробел");
        Scanner scanner = new Scanner(System.in);

        try {
            String scanTextUser = scanner.nextLine();
            String[] textUser = scanTextUser.split(" ");
            if (textUser.length != 3){
                System.out.println("Вы ввели не корректные данные");
                addToy(sumID);
            } else {
                Integer id = sumID + 1;
                String name = textUser[0];
                Integer count = Integer.valueOf(textUser[1]);
                Integer chanceOfFallingOut = Integer.valueOf(textUser[2]);
                Toy toy = new Toy(id, name, count, chanceOfFallingOut);
                ToyStore.toyList.add(toy);
                System.out.println("Успешно добавлена игрушка " + toy);
                ToyStore.toyList.stream().forEach(System.out::print);
            }
        } catch (NumberFormatException e){
            System.out.println("Данные введены не корректно!");
        }
    }
}

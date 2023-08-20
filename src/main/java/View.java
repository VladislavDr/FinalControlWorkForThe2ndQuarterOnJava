import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void menu(){
            List<Toy> toyList = new ArrayList<>();
            toyList = ToyStore.toyStore(toyList);
            List<Toy> choosingToy = new ArrayList<>();
        while (true) {
            System.out.println("Введите add, если хотите добавить игрушку. Введите print, если хотите посмотреть " +
                    " на список игрушек в магазине.\n Введите event, если хотите увидеть игрушки, " +
                    "отобранные для подарков. Введите percent, если хотите поменять шанс выпадения игрушек. \n" +
                    "Ввдетие gift, чтобы вручить призовую игрушку. Введите exit, если хотите выйти. \n");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            switch (text) {
                case "add":
                    Integer sumID = toyList.size();
                    toyList = AddToy.addToy(toyList, sumID);
                    System.out.println(toyList + " Новый список игрушек.");
                    break;
                case "print":
                    System.out.println(toyList);
                    break;
                case "event":
//                    choosingToy = ChoosingToy.run(toyList, choosingToy);
                    ChoosingToy.run(toyList, choosingToy);
                    break;
                case "gift":
                    GiftToy.GiftToy(choosingToy);
                    break;
                case "percent":
                   PercentageChange.chance(toyList);
                    break;
                case "exit":
                    System.exit(0);
            }
        }

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void menu(){
        ToyStore.toyStore();
        while (true) {
            System.out.println("\nВведите add, если хотите добавить игрушку. Введите print, если хотите посмотреть " +
                    " на список игрушек в магазине.\nВведите event, если хотите увидеть игрушки, " +
                    "отобранные для подарков. Введите percent, если хотите поменять шанс выпадения игрушек. \n" +
                    "Ввдетие gift, чтобы вручить призовую игрушку. Введите exit, если хотите выйти. \n");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            switch (text) {
                case "add":
//                    toyList = AddToy.addToy( sumID);
//                    System.out.println(toyList + " Новый список игрушек.");
                    Integer sumID = ToyStore.toyList.size();
                    AddToy.addToy(sumID);
                    break;
                case "print":
                    if(ToyStore.toyList.isEmpty()){
                        System.out.println("Нечего выводить. В магазине закончились игрушки.");
                    } else ToyStore.toyList.stream().forEach(System.out::print);
                    break;
                case "event":
                    ChoosingToy.run(ToyStore.toyList, ToyStore.choosingToy);
                    break;
                case "gift":
                    GiftToy.GiftToy(ToyStore.choosingToy);
                    break;
                case "percent":
                   PercentageChange.chance(ToyStore.toyList);
                    break;
                case "exit":
                    System.exit(0);
            }
        }

    }
}

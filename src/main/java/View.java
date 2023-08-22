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
                    Integer sumID = ToyStore.TOY_LIST.size();
                    ToyStore.AddToy(sumID);
                    break;
                case "print":
                    if(ToyStore.TOY_LIST.isEmpty()){
                        System.out.println("Нечего выводить. В магазине закончились игрушки.");
                    } else ToyStore.TOY_LIST.stream().forEach(System.out::print);
                    break;
                case "event":
                    ToyStore.ChoosingToy();
                    break;
                case "gift":
                    GiftToy.GiftToy(ToyStore.CHOOSING_TOY);
                    break;
                case "percent":
                   PercentageChange.chance(ToyStore.TOY_LIST);
                    break;
                case "exit":
                    System.exit(0);
            }
        }

    }
}

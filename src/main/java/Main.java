import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore.toyStore();
        while (true) {
            System.out.println("\nВведите add, если хотите добавить игрушку. Введите show, если хотите посмотреть " +
                    " на список игрушек в магазине.\nВведите event, если хотите увидеть игрушки, " +
                    "отобранные для подарков. Введите percent, если хотите поменять шанс выпадения игрушек. \n" +
                    "Ввдетие gift, чтобы вручить призовую игрушку. Введите exit, если хотите выйти. \n");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            switch (text) {
                case "add":
                    ToyService.addToy();
                    break;
                case "show":
                    ToyService.show();
                    break;
                case "event":
                    ToyStore.choosingToy();
                    break;
                case "gift":
                    ToyService.giftToy();
                    break;
                case "percent":
                    ToyService.chanceToyChance();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана. Попробуй еще разок.");
            }
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    public static List<Toy> toyList = new ArrayList<>();
    public static List<Toy> choosingToy = new ArrayList<>();
    public static int countChoosingToyLst = 10;
    public static List<Toy> toyStore(){
        Toy toy1 = new Toy(01, "Beer", 3, 10);
        Toy toy2 = new Toy(02, "Robot", 2, 20);
        Toy toy3 = new Toy(03, "Mouse", 1, 70);

        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
        toyList.add(new Toy(04, "Car", 2, 40));
        toyList.add(new Toy(05, "Duck", 1, 30));
        toyList.add(new Toy(06, "Puzzle", 2, 10));
        return toyList;
    }
}

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    public static List<Toy> toyStore(List<Toy> toyList){
        Toy toy1 = new Toy(01, "Beer", 3, 10);
        Toy toy2 = new Toy(02, "Robot", 5, 20);
        Toy toy3 = new Toy(03, "Mouse", 10, 70);

        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
        toyList.add(new Toy(04, "Car", 7, 40));
        toyList.add(new Toy(05, "Duck", 4, 30));
        toyList.add(new Toy(06, "Puzzle", 3, 10));
        return toyList;
    }
}

import java.util.Random;

public class GetRandom {
    public static int rnd(){
        Random rnd = new Random();
        int x = rnd.nextInt(1, 101);
        return x;
    }
}

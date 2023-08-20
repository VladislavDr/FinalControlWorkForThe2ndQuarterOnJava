import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GiftToy {
    public static void GiftToy(List<Toy> toyList){

        try (FileWriter writer = new FileWriter("List of gifts.txt", true)){
            if (!toyList.isEmpty()){
                writer.write(String.valueOf(toyList.get(0)));
                writer.write("\n");
                System.out.println("Успешно подарили " + toyList.get(0));
                toyList.remove(0);
            } else System.out.println("Список подарков пуст. Необходимо его пополнить.");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChoosingToy {
    public static List<Toy> run(List<Toy> toyList, List<Toy> choosToy) {

        Random rnd = new Random();
        Toy temp = null;
        int countToy;
        int countGiftToy = 10;
        if (choosToy.size()<countGiftToy){
            if (toyList.isEmpty()){
                System.out.println("В магазине не хвататет игрушек для дальнейшего добавления их в подарочный список");
            } else {
                int sizeLst = countGiftToy - choosToy.size();
                for (int i = 0; i < sizeLst; i++) {

                    int x = rnd.nextInt(1, 101);

                    for (int j = 0; j < toyList.size(); j++) {

                        if (toyList.get(j).getChanceOfFallingOut() > x) {
                            countToy = toyList.get(j).getCount() - 1;
                            toyList.get(j).setCount(countToy);
                            temp = toyList.get(j);

                            if (toyList.get(j).getCount() <= 0) {
                                toyList.remove(toyList.get(j));
                            }

                        } else if (j == toyList.size()-1 && temp == null){
                            temp = toyList.get(j);
                            countToy = toyList.get(j).getCount() - 1;
                            toyList.get(j).setCount(countToy);

                            if (toyList.get(j).getCount() <= 0) {
                                toyList.remove(toyList.get(j));
                            }
                        }
                    }
                    choosToy.add(temp);
                    temp = null;
                }
            }
        }
        else System.out.println("У вас заполнен список игрушек. Сперва раздарите часть.");

        System.out.println(choosToy + " - Отобранные игрушки");
        return choosToy;
    }
}


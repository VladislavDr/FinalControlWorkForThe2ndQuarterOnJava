import java.util.List;


public class ChoosingToy {
    public static List<Toy> run(List<Toy> toyList, List<Toy> choosToy) {

        Toy temp = null;
        if (choosToy.size() < ToyStore.countChoosingToyLst){
            if (toyList.isEmpty()){
                System.out.println("В магазине не хвататет игрушек для дальнейшего добавления их в подарочный список.");
            } else {
                int sizeLst = ToyStore.countChoosingToyLst - choosToy.size();
                for (int i = 0; i < sizeLst; i++) {
                    if(!toyList.isEmpty()){
                        temp = GetDropChance.getDropChance(ToyStore.toyList);
                        if(temp == null){
                            temp = GetMaxDropChance.getDropChance(ToyStore.toyList);
                        }
                    } else {
                        System.out.println("У вас закончились игрушки в магазине. Пора добавить новые.");
                        return choosToy;
                    }
                    choosToy.add(temp);
                }
            }
        }
        else System.out.println("У вас заполнен список игрушек. Сперва раздарите часть.");

        System.out.println(choosToy + " - Отобранные игрушки");
        return choosToy;
    }
}


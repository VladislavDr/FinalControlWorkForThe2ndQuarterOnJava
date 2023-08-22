import java.util.List;


public class ChoosingToyNotUsed {
    public static List<Toy> run(List<Toy> toyList, List<Toy> choosToy) {

        Toy temp = null;
        if (choosToy.size() < ToyStore.COUNT_CHOOSING_TOY){
            if (toyList.isEmpty()){
                System.out.println("В магазине не хвататет игрушек для дальнейшего добавления их в подарочный список.");
            } else {
                int sizeLst = ToyStore.COUNT_CHOOSING_TOY - choosToy.size();
                for (int i = 0; i < sizeLst; i++) {
                    if(!toyList.isEmpty()){
                        temp = GetDropChanceNotUsed.getDropChance(ToyStore.TOY_LIST);
                        if(temp == null){
                            temp = GetMaxDropChanceNotUsed.getDropChance(ToyStore.TOY_LIST);
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


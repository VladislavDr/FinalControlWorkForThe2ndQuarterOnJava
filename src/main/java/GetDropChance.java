import java.util.List;

public class GetDropChance {
    public static Toy getDropChance(List<Toy> toyList){

        Toy temp = null;
        int countToy;

        int rnd = GetRandom.rnd();
//        Iterator<Toy> iterator = toyList.iterator();
//        for (Toy toy:toyList) {
//            if (toy.getChanceOfFallingOut() > rnd){
//                temp = toy;
//                countToy = toy.getCount() - 1;
//                toy.setCount(countToy);
//                toyList.removeIf(o -> o.getCount() <= 0);
//
//            }
//        }

        for (int j = 0; j < toyList.size(); j++) {

            if (toyList.get(j).getChanceOfFallingOut() > rnd) {
                temp = toyList.get(j);
            }
        }
        if (temp != null){
            countToy = temp.getCount() - 1;
            temp.setCount(countToy);
            if(temp.getCount() == 0){
                toyList.remove(temp);
            }
        }
        return temp;
    }
}

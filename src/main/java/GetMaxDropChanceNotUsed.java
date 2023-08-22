import java.util.List;

public class GetMaxDropChanceNotUsed {
    public static Toy getDropChance(List<Toy> toyList) {
        Toy temp = null;
        Integer maxDropChance = 0;
        int countToy;
        for (int j = 0; j < toyList.size(); j++) {

            if (toyList.get(j).getChanceOfFallingOut() > maxDropChance) {
                temp = toyList.get(j);
                maxDropChance = toyList.get(j).getChanceOfFallingOut();
            }

        }
        countToy = temp.getCount() - 1;
        temp.setCount(countToy);
        if(temp.getCount() == 0){
            toyList.remove(temp);
        }
        return temp;
    }
}

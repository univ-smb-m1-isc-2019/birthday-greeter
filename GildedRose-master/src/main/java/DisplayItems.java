import java.util.ArrayList;

public class DisplayItems {
    public static void display(ArrayList<ListOfItems> itemsList) {
        for ( ListOfItems list : itemsList ) {
            System.out.println("------------" + list.getName() + "------------");
            for (Item it : list.getItems()) {
                System.out.println("Name : " + it.getName());
                System.out.println("SellIn : " + it.getSellIn());
                System.out.println("Quality : " + it.getQuality() + "\n");
            }
        }
    }
}

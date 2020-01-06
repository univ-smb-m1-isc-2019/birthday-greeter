import java.util.ArrayList;


public class GildedRose {
    private static ArrayList<ListOfItems> itemsList = null;
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");

        itemsList = ListManage.createList();
        DisplayItems.display(itemsList);
        UpdateQuality.update(itemsList);
        DisplayItems.display(itemsList);
    }


	

}
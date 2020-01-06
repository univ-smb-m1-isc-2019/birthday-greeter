import java.util.ArrayList;

public class ListOfItems {
    private String name;
    private ArrayList<Item> items;

    public ListOfItems(String name, ArrayList<Item> items){
        this.name = name;
        this.items = items;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public void addItem(Item it){
        items.add(it);
    }
}

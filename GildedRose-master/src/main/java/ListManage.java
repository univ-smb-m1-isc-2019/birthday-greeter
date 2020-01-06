import java.util.ArrayList;

public class ListManage {
    private static ArrayList<ListOfItems> itemsList = new ArrayList<>();
    private static ListOfItems legendary = new ListOfItems("legendary", new ArrayList<>());
    private static ListOfItems standard = new ListOfItems("standard", new ArrayList<>());
    private static ListOfItems conjured = new ListOfItems("conjured", new ArrayList<>());
    private static ListOfItems improved = new ListOfItems("improves", new ArrayList<>());


    public static ArrayList<ListOfItems> createList() {
        addLists();
        addItemToStandard("+5 Dexterity Vest", 10, 20);
        addItemToImproved("Aged Brie", 2, 0);
        addItemToStandard("Elixir of the Mongoose", 5, 7);
        addItemToLegendary("Sulfuras, Hand of Ragnaros", 0, 80);
        addItemToImproved("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        addItemToConjured("Conjured Mana Cake", 3, 6);
        return getItemList();
    }
    static void addLists() {
        itemsList.add(legendary);
        itemsList.add(standard);
        itemsList.add(conjured);
        itemsList.add(improved);
    }
    public static ArrayList<ListOfItems> getItemList() {
        return itemsList;
    }
    public static void addItemToLegendary(String name, int sellIn, int quality) {
        legendary.addItem(new Item(name, sellIn, quality));
        itemsList.set(itemsList.indexOf(legendary), legendary);
    }
    public static void addItemToStandard(String name, int sellIn, int quality) {
        standard.addItem(new Item(name, sellIn, quality));
        itemsList.set(itemsList.indexOf(standard), standard);
    }
    public static void addItemToConjured(String name, int sellIn, int quality) {
        conjured.addItem(new Item(name, sellIn, quality));
        itemsList.set(itemsList.indexOf(conjured), conjured);
    }
    public static void addItemToImproved(String name, int sellIn, int quality) {
        improved.addItem(new Item(name, sellIn, quality));
        itemsList.set(itemsList.indexOf(improved), improved);
    }
}

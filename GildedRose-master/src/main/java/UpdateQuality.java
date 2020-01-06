import java.util.ArrayList;

public class UpdateQuality {
    public static void update(ArrayList<ListOfItems> itemsList)
    {
        for ( ListOfItems list : itemsList ) {
            for (Item it : list.getItems()) {
                if (list.getName().equals("conjured")){
                    it.setQuality(it.getQuality() - 2);
                    if(it.getQuality() < 0){
                        it.setQuality(0);
                    }
                } else if(!list.getName().equals("improved")){
                    if ((it.getQuality() > 0) && (!list.getName().equals("legendary")))
                        it.setQuality(it.getQuality() - 1);
                } else {
                    if (it.getQuality() < 50) {
                        it.setQuality(it.getQuality() + 1);
                        if ("Backstage passes to a TAFKAL80ETC concert".equals(it.getName())) {
                            if ((it.getSellIn() < 11) && (it.getQuality() < 50))
                                it.setQuality(it.getQuality() + 1);

                            if ((it.getSellIn() < 6) && (it.getQuality() < 50))
                                it.setQuality(it.getQuality() + 1);
                        }
                    }
                }

                if (!list.getName().equals("legendary"))
                    it.setSellIn(it.getSellIn() - 1);

                if (it.getSellIn() < 0) {
                    if (!"Aged Brie".equals(it.getName())) {
                        if (!"Backstage passes to a TAFKAL80ETC concert".equals(it.getName())) {
                            if (it.getQuality() > 0)
                                if (!list.getName().equals("legendary"))
                                    it.setQuality(it.getQuality() - 1);
                        } else {
                            it.setQuality(0);
                        }
                    } else {
                        if (it.getQuality() < 50)
                            it.setQuality(it.getQuality() + 1);
                    }
                }
            }
        }
    }

}

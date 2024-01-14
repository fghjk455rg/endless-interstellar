package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class KatorItems {
    public static Item
    aluminum,nikel;

    public static final Seq<Item> KatorItems = new Seq<>();

    public static void load(){
        aluminum = new Item("aluminum",Color.valueOf("9ebda3")){{
            cost = 1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        nikel = new Item("nikel",Color.valueOf("73667c")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};

        KatorItems.addAll (
            aluminum,nikel
        );
    }
}

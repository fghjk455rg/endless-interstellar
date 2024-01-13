package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class KatorItems {
    public static Item
    //Item
    aluminum,
    //Rocket
    incendiaryRocket, explosiveRocket, fragBomb, rocketEMP, nuclearRocket;

    public static final Seq<Item> KatorItems = new Seq<>();

    public static void load(){
        //Item
        aluminum = new Item("aluminum",Color.valueOf("9ebda3")){{
            alwaysUnlocked = true;
            cost = 1f;
            hardness = 1;
        }};

        KatorItems.addAll (
            aluminum
        );
    }
}

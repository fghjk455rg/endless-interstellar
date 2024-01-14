package content;

import arc.graphics.*;
import arc.struct.Seq;
import mindustry.type.*;
import static mindustry.content.Items.*;

public class KatorItems {
    public static Item
    aluminum,quartz_dust;

    public static final Seq<Item> KatorItems = new Seq<>();

    public static void load(){
        aluminum = new Item("aluminum",Color.valueOf("9ebda3")){{
            cost = 1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        quartz_dust = new Item("quartz_dust",Color.valueOf("202020")){{
            cost = 0.5f;
            hardness = 0;
        }};

        KatorItems.addAll (
            aluminum,quartz_dust
        );
    }
}

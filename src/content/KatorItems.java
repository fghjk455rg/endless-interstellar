package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class KatorItems {
    public static Item
            aluminum,quartz,pulsealloy,sulfur;

    public static final Seq<Item> snewerusItems = new Seq<>();

    public static void load(){
        aluminum = new Item("aluminum",Color.valueOf("8697a5")){{
            cost = 1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        quartz = new Item("quartz",Color.valueOf("dee6e9")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        sulfur = new Item("sulfur",Color.valueOf("e3c367")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        pulsealloy = new Item("pulsealloy",Color.valueOf("b3485d")){{
            cost = 2f;
            charge = 1.2f;
            hardness = 1;
            alwaysUnlocked = true;
        }};

        snewerusItems.addAll (
                copper,aluminum,quartz,silicon,graphite,thorium,sulfur,plastanium,fissileMatter,pulsealloy
        );
    }
}

package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class KatorItems {
    public static Item
            ferelit,nikel,erelit,calcite,kateos,sulfur,tectonite,composite,magnod;

    public static final Seq<Item> KatorItems = new Seq<>();

    public static void load(){
        ferelit = new Item("Ferelit",Color.valueOf("e3c367")){{
            cost = 1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        nikel = new Item("Nikel",Color.valueOf("73667c")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        erelit = new Item("Erelit",Color.valueOf("d6995e")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        calcite = new Item("Calcite",Color.valueOf("df824d")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        kateos = new Item("Kateos",Color.valueOf("3a8f64")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        sulfur = new Item("Sulfur",Color.valueOf("e3c367")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        tectonite = new Item("Tectonite",Color.valueOf("dd6f63")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        composite = new Item("Composite",Color.valueOf("4d554a")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        magnod = new Item("Magnod",Color.valueOf("768a9a")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};

        KatorItems.addAll (
                ferelit,nikel,erelit,calcite,kateos,sulfur,tectonite,composite,magnod
        );
    }
}

package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class KatorItems {
    public static Item
            ferelit,nickel,erelit,calcite,kateos,sulfur,tectonite,composite,magnod;

    public static final Seq<Item> snewerusItems = new Seq<>();

    public static final Seq<Item> KatorItems = new Seq<>();

    public static void load(){
        ferelit = new Item("ferelit",Color.valueOf("e3c367")){{
            cost = 1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        nickel = new Item("nickel",Color.valueOf("73667c")){{
            cost = 1.5f;
            hardness = 2;
            alwaysUnlocked = true;
        }};
        erelit = new Item("erelit",Color.valueOf("d6995e")){{
            cost = 1.5f;
            hardness = 2;
            alwaysUnlocked = true;
        }};
        calcite = new Item("calcite",Color.valueOf("df824d")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        kateos = new Item("kateos",Color.valueOf("3a8f64")){{
            cost = 2f;
            charge = 0.1f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        sulfur = new Item("sulfur",Color.valueOf("e3c367")){{
            cost = 0.5f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        tectonite = new Item("tectonite",Color.valueOf("dd6f63")){{
            cost = 1f;
            hardness = 0;
            alwaysUnlocked = true;
        }};
        composite = new Item("composite",Color.valueOf("4d554a")){{
            cost = 4f;
            hardness = 6;
            alwaysUnlocked = true;
        }};
        magnod = new Item("magnod",Color.valueOf("768a9a")){{
            cost = 5f;
            hardness = 3;
            alwaysUnlocked = true;
        }};

        snewerusItems.addAll (
                ferelit,nickel,erelit,calcite,kateos,sulfur,tectonite,composite,magnod
        );
    }
}

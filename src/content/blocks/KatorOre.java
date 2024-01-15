package content.blocks;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import content.KatorItems;

public class KatorOre {
    public static Block oreNikel, oreFerelit, oreKateos;

    public static void load() {
        oreNikel = new OreBlock(KatorItems.nikel) {{
            oreDefault = true;
        }};
        oreFerelit = new OreBlock(KatorItems.ferelit) {{
            oreDefault = true;
        }};
        oreKateos = new OreBlock(KatorItems.kateos) {{
            oreDefault = true;
        }};
    }
}

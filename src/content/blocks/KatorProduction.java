package content.blocks;

import arc.graphics.Color;
import content.KatorItems;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPlasma;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class KatorProduction {
    public static Block
        erelitforge;
    public static void load() {
        //here I posted them in order of discovery in the tech tree
        erelitforge = new GenericCrafter("Erelit forge"){{
            size = 3;
            craftTime = 120;
            invertFlip = true;
            solid = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawRegion(),
                    new DrawPlasma(){{
                        plasma1 = Color.valueOf("ffebc6");
                        plasma2 = Color.valueOf("ffdea0");
                    }},
                    new DrawGlowRegion(){{
                        alpha = 0.5f;
                        color = Color.valueOf("ffffff");
                        glowIntensity = 2f;
                        glowScale = 5f;
                     }}
            );
            craftEffect = Fx.smokeCloud;
            outputItems = ItemStack.with(KatorItems.erelit, 1);
            requirements(Category.production, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
            consumeItem(KatorItems.ferelit, 1);
            consumePower(2f);
            squareSprite = false;
        }};
    }
}
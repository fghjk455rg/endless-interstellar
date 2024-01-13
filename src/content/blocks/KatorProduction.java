package content.blocks;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;
import mindustry.world.meta.BlockGroup;
import content.KatorItems;

import static mindustry.type.ItemStack.with;

public class KatorProduction {
    public static Block
            factory1;
    public static void load() {
        //here I posted them in order of discovery in the tech tree
        factory1 = new GenericCrafter("fucktory"){{
            size = 2;
            craftTime = 60;
            invertFlip = true;
            solid = true;
            outputsLiquid = true;
            liquidOutputDirections = new int[]{1, 3};
            drawer = new DrawMulti(
                    new DrawRegion()
            );
            craftEffect = Fx.smoke;
            group = BlockGroup.liquids;
            outputItems = ItemStack.with(KatorItems.aluminum, 1);
            requirements(Category.production, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
            consumeItem(Items.copper, 1);
            consumePower(2f);
        }};
    }
}
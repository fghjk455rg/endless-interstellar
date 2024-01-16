package content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPlasma;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class KatorBlocks {
    public static Block
            //crafter
            erelitforge,
            //storage
            corestardust
            ;

    public static void load() {
        erelitforge = new GenericCrafter("erelit-forge"){{
            requirements(Category.production, with(KatorItems.ferelit, 60, KatorItems.kateos, 60, KatorItems.nikel, 80));
            size = 3;
            craftTime = 300;
            solid = true;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawPlasma(){{
                        plasma1 = Color.valueOf("ffebc6");
                        plasma2 = Color.valueOf("ffdea0");
                    }},
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.5f;
                        color = Color.valueOf("ffffff");
                        glowIntensity = 2f;
                        glowScale = 5f;
                    }}
            );
            craftEffect = Fx.smokeCloud;
            outputItems = ItemStack.with(KatorItems.erelit, 2);
            consumeItems(with(KatorItems.ferelit, 1, KatorItems.nikel, 1,  KatorItems.sulfur, 2));
            consumePower(3f);
            squareSprite = false;
        }};
        corestardust = new CoreBlock("core-star-dust"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with( KatorItems.nikel, 400, KatorItems.ferelit, 600, KatorItems.kateos, 800));
            size = 3;
            alwaysUnlocked = true;
            squareSprite = false;
            isFirstTier = true;
            //unitType = ;
            health = 2000;
            itemCapacity = 2000;
            unitCapModifier = 10;
            envEnabled ^= Env.space;
        }};
    }
}
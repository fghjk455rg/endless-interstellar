package content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPlasma;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.Env;
import mindustry.world.draw.DrawHeatOutput;
import mindustry.world.draw.DrawLiquidTile;

import static mindustry.type.ItemStack.with;

public class KatorBlocks {
    public static Block
            //production
            screwdriver, laserdriver, rocketcher, ventpump, inertturbine, well, deepdrill, vulcaniteextractor,
            //power
            energychannel, substation, energyflow, vulcanitebattery, ionbattery, toroidalmagneticsupermassiveenergystorage, turbine, largeturbine, indoorturbine, ice,
            //crafting
            erelitforge, chemicalheater, cauldron, remover, electroliser, compositepress, passivenuclearheater, nuclearreactor, aciddecomposer, magnetizer, centrifuge,
            //distribution
            heavyconveyor, heavyrouter,
            //storage
            corestardust,
            //turrets
            vector, twins, arbitrator, shaft, hammer, heavyrain, volcano, sparky,
            //wall
            nikelwall, nikellargewall,
            //ore
            orenikel, oreferelit, orekateos, calcitedust
            ;

    public static void load() {
        //production
        screwdriver = new Drill("screwdriver"){{
            requirements(Category.production, with(KatorItems.kateos, 10, KatorItems.nikel, 18));
            tier = 2;
            drillTime = 300;
            size = 2;
            //mechanical drill doesn't work in space
            envEnabled ^= Env.space;
            consumeLiquid(Liquids.water, 0.025f).boost();
            consumePower(1f);
        }};
        laserdriver = new Drill("laserdriver"){{
            requirements(Category.production, with(KatorItems.kateos, 10, KatorItems.nikel, 18));
            tier = 3;
            drillTime = 240;
            size = 4;
            //mechanical drill doesn't work in space
            envEnabled ^= Env.space;
            consumeLiquid(Liquids.water, 0.025f).boost();
            consumePower(3f);
        }};
        //power
        energychannel = new PowerNode("energy-channel"){{
            requirements(Category.power, with(KatorItems.kateos, 2, KatorItems.nikel, 2));
            maxNodes = 4;
            laserRange = 22;
        }};
        substation = new PowerNode("substation"){{
            requirements(Category.power, with(KatorItems.kateos, 6, KatorItems.nikel, 4));
            maxNodes = 12;
            laserRange = 10;
        }};
        //crafting
        erelitforge = new GenericCrafter("erelit-forge"){{
            requirements(Category.crafting, with(KatorItems.ferelit, 60, KatorItems.kateos, 60, KatorItems.nikel, 80));
            size = 3;
            craftTime = 240;
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
            craftEffect = Fx.blastsmoke;
            consumeItems(with(KatorItems.ferelit, 1, KatorItems.nikel, 1,  KatorItems.calcite, 2));
            consumePower(3f);
            outputItems = ItemStack.with(KatorItems.erelit, 2);
            squareSprite = false;
        }};
        chemicalheater = new HeatProducer("chemical-heater"){{
            requirements(Category.crafting, with(KatorItems.ferelit, 60, KatorItems.kateos, 60, KatorItems.nikel, 80));
            size = 3;
            craftTime = 240;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(KatorLiquids.acid),
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.1f;
                        color = Color.valueOf("ffffff");
                        glowIntensity = 2f;
                        glowScale = 5f;
                    }},
                    new DrawHeatOutput()
            );
            consumeLiquid(KatorLiquids.acid, 12f);
            outputItems = ItemStack.with(KatorItems.erelit, 2);
        }};
        //distribution
        heavyconveyor = new Conveyor("heavy-conveyor"){{
            requirements(Category.distribution, with(KatorItems.kateos, 2, KatorItems.nikel, 1));
            health = 100;
            speed = 0.03f;
            displayedSpeed = 4.2f;
        }};
        //storage
        corestardust = new CoreBlock("core-star-dust"){{
            requirements(Category.effect, with( KatorItems.ferelit, 600, KatorItems.kateos, 800,KatorItems.nikel, 400));
            size = 3;
            alwaysUnlocked = true;
            isFirstTier = true;
            //unitType = ;
            health = 2000;
            itemCapacity = 2000;
            unitCapModifier = 10;
            squareSprite = false;
        }};
        //ore
        orenikel = new OreBlock(KatorItems.nikel) {{
            oreDefault = false;
        }};
        oreferelit = new OreBlock(KatorItems.ferelit) {{
            oreDefault = false;
        }};
        orekateos = new OreBlock(KatorItems.kateos) {{
            oreDefault = false;
        }};
    }
}
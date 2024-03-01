package content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class KatorBlocks {
    public static Block
            //production
            screwdriver, laserdriver, rocketcher, ventpump, inertturbine, well, deepdrill, vulcaniteextractor,
            //power
            energychannel, substation, energyflow, vulcanitebattery, ionbattery, toroidalmagneticsupermassiveenergystorage, heatgenerator, ice, turbine, largeturbine, indoorturbine,
            //crafting
            erelitforge, chemicalheater, cauldron, remover, electroliser, compositepress, passivenuclearheater, nuclearreactor, aciddecomposer, magnetizer, centrifuge,
            //distribution
            heavyconveyor, heavyrouter, overflowredirector, heavyjunction, heavybridge, heavysorter,
            //storage
            corestardust,
            //turret
            vector, twins, arbitrator, shaft, hammer, heavyrain, volcano, sparky,
            //wall
            nickelwall, nickellargewall,
            //ore
            orenikel, oreferelit, orekateos, calcitedust
            ;

    public static void load() {

        //production

        screwdriver = new Drill("screwdriver"){{
            requirements(Category.production, with(KatorItems.kateos, 10, KatorItems.nickel, 18));
            tier = 2;
            drillTime = 300;
            size = 2;
            //mechanical drill doesn't work in space
            envEnabled ^= Env.space;
            consumeLiquid(Liquids.water, 0.025f).boost();
            consumePower(1f);
        }};
        laserdriver = new Drill("laserdriver"){{
            requirements(Category.production, with(KatorItems.kateos, 1, KatorItems.nickel, 1));
            tier = 3;
            drillTime = 240;
            size = 4;
            drillEffect = Fx.mineBig;
            //mechanical drill doesn't work in space
            envEnabled ^= Env.space;
            consumeLiquid(Liquids.water, 0.025f).boost();
            consumePower(3f);
            squareSprite = false;
        }};

        //power

        energychannel = new PowerNode("energy-channel"){{
            requirements(Category.power, with(KatorItems.kateos, 2, KatorItems.nickel, 2));
            maxNodes = 3;
            laserRange = 30;
            squareSprite = false;
        }};
        substation = new PowerNode("substation"){{
            requirements(Category.power, with(KatorItems.kateos, 6, KatorItems.nickel, 4));
            maxNodes = 12;
            laserRange = 6;
            squareSprite = false;
        }};
        heatgenerator = new ThermalGenerator("heat-generator"){{
            requirements(Category.power, with(KatorItems.ferelit, 1, KatorItems.kateos, 1, KatorItems.nickel, 1));
            powerProduction = 3f;
            generateEffect = Fx.redgeneratespark;
            effectChance = 0.011f;
            size = 2;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.1f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.5f;
                        color = Color.valueOf("ffffff");
                        glowIntensity = 2f;
                        glowScale = 5f;
                    }}
            );
        }};

        //crafting

        erelitforge = new GenericCrafter("erelit-forge"){{
            requirements(Category.crafting, with(KatorItems.ferelit, 60, KatorItems.kateos, 60, KatorItems.nickel, 80));
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
            consumeItems(with(KatorItems.ferelit, 1, KatorItems.nickel, 1,  KatorItems.calcite, 2));
            consumePower(3f);
            outputItems = ItemStack.with(KatorItems.erelit, 2);
            squareSprite = false;
        }};

        chemicalheater = new HeatProducer("chemical-heater"){{
            requirements(Category.crafting, with(KatorItems.ferelit, 60, KatorItems.kateos, 60, KatorItems.nickel, 80));
            size = 3;
            craftTime = 240;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.hydrogen),
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        alpha = 0.1f;
                        color = Color.valueOf("ffffff");
                        glowIntensity = 2f;
                        glowScale = 5f;
                    }},
                    new DrawHeatOutput()
            );
            consumeLiquid(Liquids.nitrogen, 0.2f);
            consumeItem(KatorItems.kateos, 2);
            outputItems = ItemStack.with(KatorItems.calcite, 2);
            liquidCapacity = 20f;
            itemCapacity = 20;
            rotateDraw = false;
            regionRotated1 = 1;
            ambientSound = Sounds.hum;
            heatOutput = 8f;
        }};

        //distribution

        heavyconveyor = new Conveyor("heavy-conveyor"){{
            requirements(Category.distribution, with(KatorItems.kateos, 2, KatorItems.nickel, 1));
            health = 100;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            junctionReplacement = heavyjunction;
            bridgeReplacement = heavybridge;
        }};
        heavyrouter = new Router("heavy-router"){{
            requirements(Category.distribution, with(KatorItems.kateos, 5, KatorItems.nickel, 2));
            buildCostMultiplier = 4f;
            health = 120;
        }};
        overflowredirector = new OverflowGate("overflow-redirector"){{
            requirements(Category.distribution, with(KatorItems.kateos, 6, KatorItems.nickel, 3));
            buildCostMultiplier = 3f;
            health = 140;
        }};
        heavysorter = new Sorter("heavy-sorter"){{
            requirements(Category.distribution, with(KatorItems.kateos, 8, KatorItems.nickel, 2));
            buildCostMultiplier = 3f;
            health = 140;
        }};
        heavybridge = new BufferedItemBridge("heavy-bridge"){{
            requirements(Category.distribution, with(KatorItems.kateos, 5, KatorItems.nickel, 5));
            fadeIn = moveArrows = false;
            range = 4;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
            health = 120;
        }};
        heavyjunction = new Junction("heavy-junction"){{
            requirements(Category.distribution, with(KatorItems.kateos, 3, KatorItems.nickel, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            health = 120;
        }};

        //storage

        corestardust = new CoreBlock("core-star-dust"){{
            requirements(Category.effect, with( KatorItems.ferelit, 600, KatorItems.kateos, 800,KatorItems.nickel, 400));
            size = 3;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = KatorUnitTypes.hodor;
            health = 2000;
            itemCapacity = 2000;
            unitCapModifier = 10;
            squareSprite = false;
        }};

        //turret

        vector = new PowerTurret("vector"){{
            requirements(Category.turret, with( KatorItems.kateos, 40,KatorItems.nickel, 40));
            range = 140f;
            shoot.firstShotDelay = 20f;
            recoil = 2f;
            reload = 200f;
            shake = 1f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 2;
            scaledHealth = 300;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = Sounds.laser;

            consumePower(4f);

            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(
                        new RegionPart("-barrel"){{
                            heatProgress = PartProgress.warmup;
                            progress = PartProgress.recoil.curve(Interp.pow2In);
                            moveY = -3f * 4f / 3f;
                            heatColor = Color.valueOf("f03b0e");
                            mirror = false;
                            under = true;
                        }},
                        new RegionPart("-blade"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            moveX = 2f * 4f / 3f;
                            moveY = -0.5f;
                            moveRot = -20f;
                            under = true;
                        }});
            }};


            shootType = new LaserBulletType(80){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 18f;
                drawSize = 400f;
                collidesAir = false;
                length = 110f;
                ammoMultiplier = 1f;
                pierceCap = 4;
            }};
        }};

        twins = new ItemTurret("twins"){{
            requirements(Category.turret, with(KatorItems.composite, 35));
            size = 2;
            ammo(
                    KatorItems.nickel,  new BasicBulletType(3f, 58){{
                        width = 7f;
                        height = 10f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    Items.graphite, new BasicBulletType(2f, 86){{
                        width = 9f;
                        height = 12f;
                        reloadMultiplier = 0.4f;
                        ammoMultiplier = 2;
                        lifetime = 80f;
                    }},
                    KatorItems.magnod, new BasicBulletType(4f, 42){{
                        width = 7f;
                        height = 10f;
                        homingPower = 1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 6;
                        lifetime = 60f;
                    }}
            );

            shoot = new ShootAlternate(3.5f);

            recoils = 2;
            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -4f;
                    }});
                }
            }};

            recoil = 0.5f;
            shootY = 3f;
            reload = 5f;
            range = 130;
            shootCone = 10f;
            ammoUseEffect = Fx.casing1;
            health = 400;
            inaccuracy = 4f;
            rotateSpeed = 5f;
            coolant = consumeCoolant(0.2f);

            limitRange();
        }};

        //wall

        nickelwall = new Wall("nickel-wall"){{
            requirements(Category.defense, with(KatorItems.nickel, 6));
            health = 180 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
        }};
        nickellargewall = new Wall("nickel-large-wall"){{
            requirements(Category.defense, with(KatorItems.nickel, 24));
            health = 760 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
        }};

        //ore

        orenikel = new OreBlock(KatorItems.nickel) {{
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
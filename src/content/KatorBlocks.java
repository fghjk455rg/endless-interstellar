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
import mindustry.world.blocks.distribution.Conveyor;
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
            energychannel, substation, energyflow, vulcanitebattery, ionbattery, toroidalmagneticsupermassiveenergystorage, heatgenerator, turbine, largeturbine, indoorturbine, ice,
            //crafting
            erelitforge, chemicalheater, cauldron, remover, electroliser, compositepress, passivenuclearheater, nuclearreactor, aciddecomposer, magnetizer, centrifuge,
            //distribution
            heavyconveyor, heavyrouter,
            //storage
            corestardust,
            //turret
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
            drillEffect = Fx.mineBig;
            //mechanical drill doesn't work in space
            envEnabled ^= Env.space;
            consumeLiquid(Liquids.water, 0.025f).boost();
            consumePower(3f);
            squareSprite = false;
        }};

        //power

        energychannel = new PowerNode("energy-channel"){{
            requirements(Category.power, with(KatorItems.kateos, 2, KatorItems.nikel, 2));
            maxNodes = 3;
            laserRange = 30;
            squareSprite = false;
        }};
        substation = new PowerNode("substation"){{
            requirements(Category.power, with(KatorItems.kateos, 6, KatorItems.nikel, 4));
            maxNodes = 12;
            laserRange = 6;
            squareSprite = false;
        }};
        heatgenerator = new ThermalGenerator("heat-generator"){{
            requirements(Category.power, with(Items.copper, 40, Items.graphite, 35, Items.lead, 50, Items.silicon, 35, Items.metaglass, 40));
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
            consumeLiquid(KatorLiquids.acid, 0.2f);
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

        //turret

        vector = new PowerTurret("vector"){{
            requirements(Category.turret, with( KatorItems.kateos, 40,KatorItems.nikel, 40));
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
            ammo(
                    KatorItems.nikel,  new BasicBulletType(2f, 60){{
                        width = 7f;
                        height = 10f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                    }},
                    Items.graphite, new BasicBulletType(3f, 80){{
                        width = 9f;
                        height = 12f;
                        reloadMultiplier = 0.6f;
                        ammoMultiplier = 2;
                        lifetime = 80f;
                    }},
                    KatorItems.magnod, new BasicBulletType(4f, 12){{
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

        nikelwall = new Wall("nikel-wall"){{
            requirements(Category.defense, with(KatorItems.nikel, 6));
            health = 180 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
        }};
        nikellargewall = new Wall("nikel-large-wall"){{
            requirements(Category.defense, with(KatorItems.nikel, 24));
            health = 760 * 4;
            armor = 2f;
            buildCostMultiplier = 8f;
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
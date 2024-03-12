package content;

import arc.graphics.Color;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class KatorBlocks {
    public static Block
            //production
            //power
            //crafting
            //distribution
            heavyconveyor, heavyrouter, overflowredirector, heavyjunction, heavybridge, heavysorter,
            //storage
            corecolony,
            //turret
            vector, twins, arbitrator, sparky,
            //wall
            //ore
            orealuminum, orequartz, acid
            ;

    public static void load() {

        //distribution

        heavyconveyor = new Conveyor("heavy-conveyor"){{
            requirements(Category.distribution, with(Items.copper, 2, KatorItems.aluminum, 1));
            health = 100;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            junctionReplacement = heavyjunction;
            bridgeReplacement = heavybridge;
        }};
        heavyrouter = new Router("heavy-router"){{
            requirements(Category.distribution, with(Items.copper, 5, KatorItems.aluminum, 2));
            buildCostMultiplier = 4f;
            health = 120;
        }};
        overflowredirector = new OverflowGate("overflow-redirector"){{
            requirements(Category.distribution, with(Items.copper, 6, KatorItems.aluminum, 3));
            buildCostMultiplier = 3f;
            health = 140;
        }};
        heavysorter = new Sorter("heavy-sorter"){{
            requirements(Category.distribution, with(Items.copper, 8, KatorItems.aluminum, 2));
            buildCostMultiplier = 3f;
            health = 140;
        }};
        heavybridge = new BufferedItemBridge("heavy-bridge"){{
            requirements(Category.distribution, with(Items.copper, 5, KatorItems.aluminum, 5));
            fadeIn = moveArrows = false;
            range = 4;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
            health = 120;
        }};
        heavyjunction = new Junction("heavy-junction"){{
            requirements(Category.distribution, with(Items.copper, 3, KatorItems.aluminum, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            health = 120;
        }};

        //storage

        corecolony = new CoreBlock("core-colony"){{
            requirements(Category.effect, with( Items.copper, 400, KatorItems.aluminum, 800,KatorItems.quartz, 200));
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
            requirements(Category.turret, with( Items.copper, 40,KatorItems.aluminum, 40,KatorItems.quartz, 20));
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

        /*twins = new ItemTurret("twins"){{
            requirements(Category.turret, with(KatorItems.pulsealloy, 35));
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
         */

        //ore

        orealuminum = new OreBlock(KatorItems.aluminum) {{
            oreDefault = false;
        }};
        orequartz = new OreBlock(KatorItems.quartz) {{
            oreDefault = false;
        }};
        acid = new Floor("acidfloor"){{
            drownTime = 150f;
            status = StatusEffects.corroded;
            statusDuration = 240f;
            speedMultiplier = 0.5f;
            variants = 0;
            liquidDrop = KatorLiquids.acid;
            liquidMultiplier = 0.5f;
            isLiquid = true;
            cacheLayer = CacheLayer.cryofluid;
        }};
    }
}
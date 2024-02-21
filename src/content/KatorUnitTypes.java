package content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.ErekirUnitType;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static mindustry.content.StatusEffects.burning;

public class KatorUnitTypes {
    public static UnitType
            hodor, corseid;

    public static void load() {
        hodor = new ErekirUnitType("hodor"){{
            constructor = MechUnit::create;
            canBoost = true;
            boostMultiplier = 1.5f;
            speed = 0.5f;
            hitSize = 7f;
            health = 120f;
            buildSpeed = 0.8f;
            alwaysUnlocked = true;

            ammoType = new PowerAmmoType(1000);

            weapons.add(new Weapon("kator-hodor-weapon"){{
                top = false;
                shootY = 2f;
                reload = 30f;
                x = 4.5f;
                alternate = false;
                ejectEffect = Fx.none;
                recoil = 2f;

                bullet = new BasicBulletType(5f, 20){{
                    width = 6f;
                    height = 8f;
                    lifetime = 40f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.1f;
                    healPercent = 5f;
                    collidesTeam = true;
                }};
            }});
    }};
        corseid = new ErekirUnitType("corseid"){{
            constructor = LegsUnit::create;
            speed = 0.72f;
            drag = 0.11f;
            hitSize = 9f;
            rotateSpeed = 3f;
            health = 680;
            armor = 4f;
            legStraightness = 0.3f;
            stepShake = 0f;

            legCount = 6;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 3;
            rippleScale = 0.2f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("kator-corseid-weapon"){{
                shootSound = Sounds.blaster;
                showStatSprite = false;
                x = 5f;
                y = -1.5f;
                shootY = 4f;
                reload = 30f;

                bullet = new BasicBulletType(4f, 20){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    status = burning;

                    collidesTiles = true;
                    backColor = hitColor = Color.valueOf("feb380");
                    frontColor = Color.white;

                    knockback = 1f;
                    lifetime = 60f;
                    width = height = 9f;
                    splashDamageRadius = 5f;
                    splashDamage = 20f;

                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.none;
                    trailColor = backColor;

                    trailInterp = Interp.slope;

                    shrinkX = 0.6f;
                    shrinkY = 0.2f;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect(){{
                        colorFrom = colorTo = Color.valueOf("feb380");
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});

        }};
}
}
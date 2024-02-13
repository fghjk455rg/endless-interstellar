package content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.PowerAmmoType;

public class KatorUnitTypes {
    public static UnitType
            hodor;

    public static void load() {
        hodor = new UnitType("hodor"){{
            constructor = MechUnit::create;
            canBoost = true;
            boostMultiplier = 1.5f;
            speed = 0.5f;
            hitSize = 7f;
            health = 120f;
            buildSpeed = 0.8f;
            alwaysUnlocked = true;

            ammoType = new PowerAmmoType(1000);

            weapons.add(new Weapon("hodor-weapon"){{
                top = false;
                shootY = 2f;
                reload = 24f;
                x = 4.5f;
                alternate = false;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.lasershoot;

                bullet = new LaserBoltBulletType(5f, 20){{
                    lifetime = 30f;
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Pal.bulletYellow;
                    frontColor = Color.white;
                }};
            }});
    }};
}
}
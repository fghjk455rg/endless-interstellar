package content;

import arc.graphics.*;
import mindustry.type.*;

public class KatorLiquids {
    public static Liquid acid, argon, steam;

    public static void load() {
        acid = new Liquid("associated-petroleum-gas", Color.valueOf("7c539e")) {{
        }};
        argon = new Liquid("masut", Color.valueOf("0d151f")){{
            gas = true;
        }};
        steam = new Liquid("steam", Color.valueOf("f0f0f0")) {{
            temperature = 1f;
            gas = true;
        }};
    }
}


package content;

import arc.graphics.*;
import mindustry.type.*;

public class KatorLiquids {
    public static Liquid acid, argon, steam;

    public static void load() {
        acid = new Liquid("acid", Color.valueOf("87eba1")) {{
        }};
        argon = new Liquid("argon", Color.valueOf("a783fb")){{
            gas = true;
        }};
        steam = new Liquid("steam", Color.valueOf("f8feff")) {{
            temperature = 1f;
            gas = true;
        }};
    }
}


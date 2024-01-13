package example;

import arc.*;
import arc.util.*;
import content.KatorBlocks;
import content.KatorItems;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("You know the rules...");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.button("And so do i... SAY GOODBYE", dialog::hide).size(400f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        KatorItems.load();
        KatorBlocks.load();
    }
}
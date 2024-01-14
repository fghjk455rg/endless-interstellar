package example;

import arc.Events;
import arc.util.Log;
import arc.util.Time;
import content.KatorBlocks;
import content.KatorItems;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("You know the rules...");
                dialog.cont.add("And so do i...").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.button("SAY GOODBYE", dialog::hide).size(400f, 50f);
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
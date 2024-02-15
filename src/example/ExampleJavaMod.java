package example;

import arc.Events;
import arc.util.Log;
import arc.util.Time;
import content.KatorBlocks;
import content.KatorItems;
import content.KatorLiquids;
import content.KatorUnitTypes;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("New content every week!");
                dialog.cont.add("And so do i...").row();
                dialog.cont.button("SAY GOODBYE", dialog::hide).size(200f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        KatorItems.load();
        KatorLiquids.load();
        KatorUnitTypes.load();
        KatorBlocks.load();
    }
}
package idsplugin;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;

public class IdsPlugin extends Plugin {

    @Override
    public void registerClientCommands(CommandHandler handler) {

        handler.<Player>register("getid", "<player>", "View a players' id.", (args, player) -> {
            Player other = Groups.player.find(p -> p.name.equalsIgnoreCase(args[0]));
            if(other == null) {
                player.sendMessage("[scarlet]No player by that name found! try using the \"listids\" command.");
                return;
            }
            player.sendMessage(player.name + "[]'s ID: " + player.id);
        });

        handler.<Player>register("listids", "", "List the ids of all players in the server.", (args, player) -> {
            Groups.player.forEach((p) -> {
                player.sendMessage(p.name + "[]'s ID: " + p.id);
            });
        });
    }
}
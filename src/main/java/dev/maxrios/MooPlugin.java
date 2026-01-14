package dev.maxrios;

import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.maxrios.commands.MooCommand;
import dev.maxrios.events.MooEvent;

import javax.annotation.Nonnull;

public class MooPlugin extends JavaPlugin {

    public MooPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new MooCommand("moo", "Enable or disable moo-ing"));
        this.getEventRegistry().registerGlobal(PlayerChatEvent.class, MooEvent::onPlayerChat);
    }
}
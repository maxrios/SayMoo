package dev.maxrios.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import dev.maxrios.events.MooEvent;

import javax.annotation.Nonnull;

public class MooCommand extends CommandBase {

    public MooCommand(String name, String description) {
        super(name, description);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext context) {
        MooEvent.isMooEnabled = !MooEvent.isMooEnabled;
        context.sendMessage(Message.raw(MooEvent.isMooEnabled ? "Moo Enabled" : "Moo Disabled"));
    }
}
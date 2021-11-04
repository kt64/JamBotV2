package com.kt64.jambotv2.commands.commands;

import com.kt64.jambotv2.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0xa537fd);
        embedBuilder.setTitle("Useful Commands");
        embedBuilder.setDescription("**!help** - *Prints all commands utilized with JamBot v2*");

        textChannel.sendMessage(embedBuilder.build()).queue();
    }
}

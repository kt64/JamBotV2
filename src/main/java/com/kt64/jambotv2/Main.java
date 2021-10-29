package com.kt64.jambotv2;

import config.ConfigFile;
import config.ConfigValues;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    private static JDABuilder jdaBuilder;
    private GuildMessageReceivedEvent event;

    public static void main(String[] args) {

        ConfigFile.loadConfig();
        ConfigValues.loadValues();

        jdaBuilder = JDABuilder.createDefault(ConfigValues.DISCORD_TOKEN);

        jdaBuilder.setStatus(OnlineStatus.IDLE);
        jdaBuilder.setActivity(Activity.playing("IntelliJ"));

        jdaBuilder.addEventListeners(new Main());

        try {
            jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        String[] arguments = event.getMessage().getContentRaw().split(" ");
        if (arguments[0].equals("!mention")){
            Member member = event.getMessage().getMentionedMembers().get(0);
            if (!member.getUser().isBot()){
                event.getChannel().sendMessage("You've mentioned the person" + member.getUser().getAsMention()).queue();
            } else {
                event.getChannel().sendMessage("You tried to hit up a bot, that can't happen").queue();
            }
        }
    }
}

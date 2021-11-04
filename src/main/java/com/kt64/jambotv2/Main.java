package com.kt64.jambotv2;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import config.ConfigFile;
import config.ConfigValues;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.awt.*;

public class Main extends ListenerAdapter {

    private static JDA jda;
    private GuildMessageReceivedEvent event;
    private static AudioPlayerManager playerManager;
    private static com.kt64.jambotv2.music.AudioPlayerManager audioPlayerManager;

    public static void main(String[] args) {

        ConfigFile.loadConfig();
        ConfigValues.loadValues();

        JDABuilder jdaBuilder = JDABuilder.createDefault(ConfigValues.DISCORD_TOKEN);

        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        jdaBuilder.setActivity(Activity.playing("Words, Words, Words"));

        jdaBuilder.addEventListeners(new Main());

        AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);
        audioPlayerManager = new com.kt64.jambotv2.music.AudioPlayerManager();

        try {
            jda = jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        String arguments = event.getMessage().getContentRaw();
        if(arguments.equals("!embeddedmessage")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Embedded Title");
            embedBuilder.setColor(0x2ecc71);
            embedBuilder.setDescription(("This is a description part 1\nThis is a description part 2"));
            embedBuilder.setFooter("This is the footer", event.getAuthor().getAvatarUrl());
            embedBuilder.setThumbnail(event.getAuthor().getAvatarUrl());
            embedBuilder.setImage(event.getAuthor().getAvatarUrl());

            event.getChannel().sendMessage(embedBuilder.build()).queue();
        }
    }

    public static JDA getJda(){
        if(jda != null){
            return jda;
        }
        return null;
    }

    public static AudioPlayerManager playerManager(){
        if(playerManager != null){
            return playerManager;
        }
        return null;
    }
}

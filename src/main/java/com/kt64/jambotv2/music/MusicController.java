package com.kt64.jambotv2.music;

import com.kt64.jambotv2.Main;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.Guild;

public class MusicController {

    private Guild guild;
    private AudioPlayer audioPlayer;

    public MusicController(Guild guild){
        this.guild = guild;
        this.audioPlayer = Main.playerManager().createPlayer();

        this.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(audioPlayer));
        this.audioPlayer.setVolume(25);
    }

    public Guild getGuild(){
        if(this.guild != null){
            return this.guild;
        }
        return null;
    }

    public AudioPlayer getAudioPlayer(){
        if(this.audioPlayer != null){
            return audioPlayer;
        }
        return null;
    }
}

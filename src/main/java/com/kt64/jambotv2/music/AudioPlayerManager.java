package com.kt64.jambotv2.music;

import com.kt64.jambotv2.Main;

import java.util.HashMap;

public class AudioPlayerManager {

    public HashMap<Long, MusicController> controllerHashMap;

    public AudioPlayerManager(){
        this.controllerHashMap = new HashMap<Long, MusicController>();
    }

    public MusicController getMusicController(long guild){
        MusicController musicController = null;

        if(this.controllerHashMap.containsKey(guild)){
            musicController = this.controllerHashMap.get(guild);
        } else {
            musicController = new MusicController(Main.getJda().getGuildById(guild));
            this.controllerHashMap.put(guild, musicController);
        }

        return musicController;
    }

}

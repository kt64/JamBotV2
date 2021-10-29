package com.kt64.jambotv2;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;

public class Main {


    private static JDABuilder jdaBuilder;

    public static void main(String[] args) {

        jdaBuilder.setToken(Config.get("DISCORD_TOKEN"));

        jdaBuilder.setStatus(OnlineStatus.IDLE);
        jdaBuilder.setActivity(Activity.playing("IntelliJ"));

        try {
            jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}

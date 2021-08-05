package me.petterim1.scoreboards;

import cn.nukkit.Player;

import java.util.Arrays;

public class ScoreboardSet {

    public static void setTitle (String title){
        Main.scoreboardTitle = title;
    }
    public static void addText (String line1){
        Main.scoreboardText  = Arrays.asList(line1);
    }
    public static void addText (String line1, String line2){
        Main.scoreboardText  = Arrays.asList(line1, line2);
    }
    public static void addText (String line1, String line2, String line3){
        Main.scoreboardText  = Arrays.asList(line1, line2, line3);
    }
    public static void addText (String line1, String line2, String line3, String line4){
        Main.scoreboardText  = Arrays.asList(line1, line2, line3, line4);
    }
    public static void addText (String line1, String line2, String line3, String line4, String line5){
        Main.scoreboardText  = Arrays.asList(line1, line2, line3, line4, line5);
    }
    public static void setLine (Integer number){
        ScoreboardUpdater.line = number;
    }
    public static void clearText(){
        Main.scoreboardText.clear();
    }
    public static void hide(Player p){
        Main.scoreboards.get(p).hideFor(p);
    }
    public static void show(Player p){
        Main.scoreboards.get(p).showFor(p);
    }

}

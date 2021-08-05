package me.petterim1.scoreboards;

import cn.nukkit.Player;

import cn.nukkit.Server;
import de.theamychan.scoreboard.api.ScoreboardAPI;
import de.theamychan.scoreboard.network.DisplaySlot;
import de.theamychan.scoreboard.network.Scoreboard;
import de.theamychan.scoreboard.network.ScoreboardDisplay;

import java.util.Map;
import java.util.UUID;

import static me.petterim1.scoreboards.Main.th;

public class ScoreboardUpdater implements Runnable {

    public static int line;

    @Override
    public void run() {
        try {
            Map<UUID, Player> players = Server.getInstance().getOnlinePlayers();
            if (!players.isEmpty()) {
                for (Player p : players.values()) {
                    if (!p.spawned || Main.noScoreboardWorlds.contains(p.getLevel().getName())) {
                        continue;
                    }

                    Scoreboard scoreboard = ScoreboardAPI.createScoreboard();
                    ScoreboardDisplay scoreboardDisplay = scoreboard.addDisplay(DisplaySlot.SIDEBAR, "dumy", Main.scoreboardTitle);

                    if (th){ Main.scoreboardText.forEach((text) -> scoreboardDisplay.addLine(Main.getScoreboardString(p, text), line));}

                    try {
                        Main.scoreboards.get(p).hideFor(p);
                    } catch (Exception ignored) {
                    }

                    scoreboard.showFor(p);
                    Main.scoreboards.put(p, scoreboard);
                    //line = 0;
                }
            }
        } catch (Exception ignored) {
        }
    }
}

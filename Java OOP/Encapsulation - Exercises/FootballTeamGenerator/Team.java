package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {

        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.isEmpty()) {

            System.out.println("A name should not be empty.");
            return;
        }

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void addPlayer(Player player) {

        if (player.isPlayerValid()) {
            this.players.add(player);
        }
    }

    public void removePlayer(String playerName) {

        for (int i = 0; i < this.players.size(); i++) {
            Player player = this.players.get(i);

            if (player.getName().equals(playerName)) {
                this.players.remove(player);
                return;
            }
        }

        System.out.printf("Player %s is not in %s team.%n", playerName, this.name);
    }

    public double getRating() {

        double teamRating = 0;

        for (int i = 0; i < this.players.size(); i++) {

            Player player = this.players.get(i);
            teamRating += player.overallSkillLevel();
        }

        return teamRating;

    }
}

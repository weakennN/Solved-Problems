package Encapsulation.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("END")) {

            String[] tokens = command.split(";+");

            String com = tokens[0];

            if (com.equals("Add")) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);

                addPlayer(teams, teamName, playerName, endurance, sprint, dribble, passing, shooting);
            } else if (com.equals("Team")) {
                String teamName = tokens[1];
                createTeam(teams, teamName);

            } else if (com.equals("Remove")) {
                removePlayer(teams, tokens[1], tokens[2]);
            } else if (com.equals("Rating")) {

                String teamName = tokens[1];
                getRating(teams, teamName);
            }

            command = scan.nextLine();
        }

    }

    public static void createTeam(Map<String, Team> teams, String teamName) {

        if (!teams.containsKey(teamName)) {
            Team team = new Team(teamName);
            teams.put(teamName, team);
        }
    }

    public static void removePlayer(Map<String, Team> teams, String teamName, String playerName) {

        if (teams.containsKey(teamName)) {
            Team team = teams.get(teamName);
            team.removePlayer(playerName);
        }
    }

    public static void addPlayer(Map<String, Team> teams, String teamName, String playerName, int endurance, int sprint, int dribble, int passing, int shooting) {

        if (teams.containsKey(teamName)) {
            Team team = teams.get(teamName);
            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
            team.addPlayer(player);
        }else {
            System.out.println("Team " + teamName + " does not exist.");
        }

    }

    public static void getRating(Map<String, Team> teams, String teamName) {

        if (teams.containsKey(teamName)) {

            Team team = teams.get(teamName);
            System.out.println(team.getName() + " - " + Math.round(team.getRating()));

        } else {
            System.out.println("Team " + teamName + " does not exist.");
        }
    }


}

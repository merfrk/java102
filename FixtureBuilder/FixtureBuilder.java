package FixtureBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureBuilder {
    List<String> teams;

    public FixtureBuilder() {
        teams = new ArrayList<>();
    }

    public FixtureBuilder(List<String> teams) {
        this.teams = teams;
    }

    public void add(String teamName) {
        teams.add(teamName);
    }

    public void generateMatches() {
        int size = teams.size();
        if (size % 2 == 1) {
            teams.add("Bay");
        }

        List<String> round = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            for (int k = 0; k < teams.size(); k++) {
                if (k == i) continue;
                String match = teams.get(i) + " vs " + teams.get(k);
                round.add(match);
            }
        }
        System.out.println("Takımlar ");
        for (String team : teams) {
            if (!team.equals("Bay"))
                System.out.println("- " + team);
        }
        int plus = teams.size();
        Collections.shuffle(round);
        for (int i = 0; i < (teams.size() - 1) * 2; i++) {
            System.out.println();
            System.out.println("Round " + (i + 1));
            System.out.println(round.get(i));
            System.out.println(round.get((i+plus)% round.size()));
            System.out.println(round.get((i+plus*2)% round.size()));
        }
    }
}

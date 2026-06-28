package Low_Level_Design.Problems.crickbuzz.model;

import java.util.List;

public class Team {
    private String name;
    private String teamId;
    private List<Player> players;

    public Team(String name, String teamId, List<Player> players) {
        this.name = name;
        this.teamId = teamId;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

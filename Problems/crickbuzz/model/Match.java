package Low_Level_Design.Problems.crickbuzz.model;

import java.util.*;

import javax.xml.stream.events.Comment;
public class Match {
    private String matchId;
    private Team team1;
    private Team team2;
    private String venue;
    private String date;
    private String time;
    private String status;
    private Innings innnings1;
    private Innings innings2;
    private List<String> commentry;
    private boolean isFirstInnings;

    public Match(String matchId, Team team1, Team team2, String venue, String date, String time, String status, Innings innnings1, Innings innings2) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.status = status;
        this.innnings1 = innnings1;
        this.innings2 = innings2;
        this.commentry = new ArrayList<>();
        this.isFirstInnings = true;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsFirstInnings() {
        return isFirstInnings;
    }

    public void setIsFirstInnings(boolean isFirstInnings) {
        this.isFirstInnings = isFirstInnings;
    }

    public Innings getInnings1() {
        return innnings1;
    }

    public void setInnings1(Innings innnings1) {
        this.innnings1 = innnings1;
    }

    public Innings getInnings2() {
        return innings2;
    }

    public void setInnings2(Innings innings2) {
        this.innings2 = innings2;
    }

    public void addCommentry(String comment) {
        if (commentry == null) {
            commentry = new ArrayList<>();
        }
        commentry.add(comment);
    }
    public List<String> getCommentry() {
        return this.commentry;
    }
}

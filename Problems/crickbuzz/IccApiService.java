package Low_Level_Design.Problems.crickbuzz;

public class IccApiService {
    private int runs;
    private int wickets;
    private int overs;

    public IccApiService(int runs, int wickets, int overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public int getRuns(){
        return this.runs;
    }

    public int getWickets(){
        return this.wickets;
    }

    public int getOvers(){
        return this.overs;
    }

    public void updateScore(int runs, int wickets, int overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }
}

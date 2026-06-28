package Low_Level_Design.Problems.crickbuzz;

public class CricBuzz {
    private int runs;
    private int wickets;
    private int overs;
    private IccApiService iccApiService;// this violates DIP 

    public CricBuzz(){
        this.iccApiService = new IccApiService(0, 0, 0);
    }

    public void updateScore(int runs, int wickets, int overs){
        while(true){
            iccApiService.updateScore(runs, wickets, overs);
            // we can wriet a logic to check if the runs or workcet or overs are updated, then we update them also
            if(this.runs != iccApiService.getRuns()){
                // when ever there is mismatch we need to update our values also
                this.overs = iccApiService.getOvers();
                this.runs = iccApiService.getRuns();
                this.wickets = iccApiService.getWickets();
            }
        }
    }
}

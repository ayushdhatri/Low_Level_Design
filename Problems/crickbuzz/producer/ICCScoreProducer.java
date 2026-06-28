package Low_Level_Design.Problems.crickbuzz.producer;

import Low_Level_Design.Problems.crickbuzz.model.Match;
import Low_Level_Design.Problems.crickbuzz.subscribers.ScoreBoardSubscriber;

public class ICCScoreProducer implements Producer
 {
    Match match;
    private ScoreBoardSubscriber scoreBoardSubscriber;
    ICCScoreProducer(Match match, ScoreBoardSubscriber scoreBoardSubscriber){
        this.match = match;
        this.scoreBoardSubscriber = scoreBoardSubscriber;
    }

    public void scoreUpdate(String runs, String over, String ball, String wickets, boolean isFirstInnings){
       this.scoreBoardSubscriber.update(this);
    }

    @Override
    public Match getMatchData() {
        return this.match;
    }

}

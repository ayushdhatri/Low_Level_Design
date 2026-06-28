package Low_Level_Design.Problems.crickbuzz.subscribers;

import Low_Level_Design.Problems.crickbuzz.model.Innings;
import Low_Level_Design.Problems.crickbuzz.model.Match;
import Low_Level_Design.Problems.crickbuzz.producer.Producer;

public class ScoreBoardSubscriber implements Subscriber {
    private Match match;

    public ScoreBoardSubscriber(Match match) {
        this.match = match;
    }

    public void update(String curentOver, String currentBall, String wickets, String curretScore, boolean isFirstInnings){
        Innings innings = isFirstInnings ? match.getInnings1() : match.getInnings2();
        innings.setCurrentOver(curentOver);
        innings.setCurrentBall(currentBall);
        innings.setWickets(wickets);
        innings.setCurrentScore(curretScore);
    }

    @Override
    public void update(Producer producer) {
        boolean isFirstInnings = producer.getMatchData().getIsFirstInnings();
        Innings inningsProducer = isFirstInnings ? producer.getMatchData().getInnings1() : producer.getMatchData().getInnings2();

        Innings inningsSubsciber = isFirstInnings ? match.getInnings1() : match.getInnings2();

        inningsSubsciber.setCurrentOver(inningsProducer.getCurrentOver());
        inningsSubsciber.setCurrentBall(inningsProducer.getCurrentBall());
        inningsSubsciber.setWickets(inningsProducer.getWickets());
        inningsSubsciber.setCurrentScore(inningsProducer.getCurrentScore());
        



    }
    
    
}

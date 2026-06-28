package Low_Level_Design.Problems.crickbuzz.subscribers;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.Problems.crickbuzz.producer.Producer;

public class CommentrySubscriber implements Subscriber {
    private List<String> commentryList;

    public CommentrySubscriber(){
        this.commentryList = new ArrayList<>();
    }

    @Override
    public void update(Producer producer) {
        this.commentryList.add(producer.getMatchData().getCommentry().getLast());
    }
    
}

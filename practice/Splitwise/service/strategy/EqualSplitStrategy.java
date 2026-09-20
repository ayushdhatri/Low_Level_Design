package Low_Level_Design.practice.Splitwise.service.strategy;

import java.util.ArrayList;
import java.util.List;


import Low_Level_Design.practice.Splitwise.models.Split;
import Low_Level_Design.practice.Splitwise.models.User;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(double amount, List<User> participants, List<Double> splitValues) {
        // This amount should be eaull split to all the particpants including the userPaidBy
        if(participants.size() == 0){
            throw new IllegalArgumentException("Participants list cannot be empty");
        }
        List<Split> splits = new ArrayList<>();
        int totalParticipants = participants.size();
        double perParticipentSplit = amount / (1.00 * totalParticipants);

        for(User user : participants){
            Split split = new Split(user, perParticipentSplit);
            splits.add(split);
        }
        return splits;
    }
    
}

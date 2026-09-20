package Low_Level_Design.practice.Splitwise.service.strategy;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.Splitwise.models.Split;
import Low_Level_Design.practice.Splitwise.models.User;

public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(double amount, List<User> participants, List<Double> splitValues) {
        if(participants.size() == 0){
            throw new IllegalStateException("Participants cannot be zero");
        }
        if(splitValues.size() == 0 || splitValues.size() != participants.size()){
            throw new IllegalStateException("Split percentage cannot be less than partipants");
        }
        // user index matches exactly with splitValues index
        List<Split> splits = new ArrayList<>();

        int n = participants.size();// here we are sure that splits values and particpants size are equal
        for(int i = 0;i<n;i++){
            User user = participants.get(i);
            double splitPercentage = splitValues.get(i);
            double splitAmount = (amount * splitPercentage)/100.00;
            splits.add(new Split(user, splitAmount));
        }
        return splits;
    }
    

    
}

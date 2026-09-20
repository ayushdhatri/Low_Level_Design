package Low_Level_Design.practice.Splitwise.service.strategy;

import java.util.List;

import Low_Level_Design.practice.Splitwise.models.Expense;
import Low_Level_Design.practice.Splitwise.models.Split;
import Low_Level_Design.practice.Splitwise.models.User;

public interface SplitStrategy {
    List<Split> split(double amount, List<User> participants, List<Double> splitValues);
}

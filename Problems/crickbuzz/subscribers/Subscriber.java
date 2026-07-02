package Low_Level_Design.Problems.crickbuzz.subscribers;

import Low_Level_Design.Problems.crickbuzz.producer.Producer;

public interface Subscriber {
    void update(Producer producer);
} 
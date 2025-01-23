package Assignment3.Interfaces.Task18;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        for (int i = items.size() - 1; i > 0; i--) {
            Person first = items.get(i - 1);
            Person second = items.get(i);
            second.pull(first);
        }
    }
}

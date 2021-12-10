package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> prevMap = previous
                .stream()
                .collect(
                        Collectors.toMap(User::getId,
                                User::getName));
        for (User u : current) {
            int id = u.getId();
            boolean containsKey = prevMap.containsKey(id);
            if (containsKey && !u.getName().equals(prevMap.get(id))) {
                changed++;
            }
            if (!containsKey) {
                added++;
            }
            prevMap.remove(id);
        }
        return new Info(added, changed, prevMap.size());
    }
}

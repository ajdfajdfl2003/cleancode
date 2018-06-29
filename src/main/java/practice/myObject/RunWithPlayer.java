package practice.myObject;

import java.util.HashSet;
import java.util.Set;

public class RunWithPlayer {
    public static void main(String[] args) {
        User user = new User("1");

        Player player = new PlayerOverrideEqual(user);
        Player playerDouble = new PlayerOverrideEqual(user);
        System.out.println("With same user: " + user.getId());
        System.out.println("Is player equals to playerDouble: " + player.equals(playerDouble));

        Set<Player> sets = new HashSet<>();
        sets.add(player);
        sets.add(playerDouble);

        System.out.println("HashSet size: " + sets.size());
    }
}

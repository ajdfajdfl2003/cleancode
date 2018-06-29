package practice.myObject;

public class RunWithPlayer {
    public static void main(String[] args) {
        User user = new User("1");

        Player player = new Player(user);
        Player playerDouble = new Player(user);
        System.out.println("With same user: " + user.getId());
        System.out.println("Is player equals to playerDouble: " + player.equals(playerDouble));
    }
}

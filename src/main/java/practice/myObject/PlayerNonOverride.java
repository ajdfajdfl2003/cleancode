package practice.myObject;

public class PlayerNonOverride implements Player {
    private final String id;

    public PlayerNonOverride(User user) {
        this.id = user.getId();
    }
}

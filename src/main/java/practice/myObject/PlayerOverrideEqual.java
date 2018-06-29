package practice.myObject;

import java.util.Objects;

public class PlayerOverrideEqual implements Player {
    private final String id;

    public PlayerOverrideEqual(User user) {
        this.id = user.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerOverrideEqual that = (PlayerOverrideEqual) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

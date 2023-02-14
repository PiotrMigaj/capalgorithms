package pl.migibud.treeset;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
class User implements Comparable<User> {
    String name;

    @Override
    public int compareTo(User o) {
        return -1 * this.name.compareTo(o.name);
    }
}

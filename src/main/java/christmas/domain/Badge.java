package christmas.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Badge {
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타");

    private final int value;
    private final String name;

    Badge(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Optional<Badge> of(int value) {
        return Arrays.stream(Badge.values())
                .sorted()
                .filter(badge -> badge.value <= value)
                .findFirst();
    }

    public String getName() {
        return name;
    }
}

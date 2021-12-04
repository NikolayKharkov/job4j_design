package ru.job4j.generic;

public class Role extends Base {

    private final int justNumber;

    public Role(String id, int justNumber) {
        super(id);
        this.justNumber = justNumber;
    }

    public int getJustNumber() {
        return justNumber;
    }
}
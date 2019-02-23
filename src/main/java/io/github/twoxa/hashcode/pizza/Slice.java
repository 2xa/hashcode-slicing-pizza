package io.github.twoxa.hashcode.pizza;

import lombok.Data;

@Data
public class Slice {

    private final int startRow;
    private final int startColumn;
    private final int endRow;
    private final int endColumn;

    public int size() {
        return (endRow - startRow + 1) * (endColumn - startColumn + 1);
    }
}

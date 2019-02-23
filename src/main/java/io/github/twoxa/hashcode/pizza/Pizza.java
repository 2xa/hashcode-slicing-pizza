package io.github.twoxa.hashcode.pizza;

import lombok.Data;

@Data
public class Pizza {

    private final int rows;

    private final int columns;

    private final int minOfType;

    private final int maxCells;

    private final char[][] cells;
}

package io.github.twoxa.hashcode.pizza;

import lombok.Data;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

@Data
public class Pizza {

    private final int rows;

    private final int columns;

    private final int minOfType;

    private final int maxCells;

    private final Ingredient[][] cells;

    public Stream<Cell> cellStream() {
        return IntStream.range(0, this.rows)
                .mapToObj(row -> IntStream.range(0, this.columns)
                        .mapToObj(column -> new Cell(row, column, cells[row][column])))
                .flatMap(identity());
    }


    @Data
    public static class Cell {
        private final int row;
        private final int column;
        private final Ingredient ingredient;
    }

    public enum Ingredient {
        MUSHROOM, TOMATO
    }
}

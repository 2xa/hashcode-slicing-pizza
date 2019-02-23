package io.github.twoxa.hashcode.pizza;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

@Data
public class Pizza implements Predicate<Slice> {

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

    @Override
    public boolean test(Slice slice) {
        return true;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", minOfType=" + minOfType +
                ", maxCells=" + maxCells +
                ", ingredients=\n" + prettyPrintIngredients() +
                '}';
    }

    private String prettyPrintIngredients() {
        StringBuilder result = new StringBuilder();
        for (Ingredient[] ingredients : cells) {
            for (Ingredient ingredient : ingredients) {
                result.append(ingredient);
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Data
    static class Cell {

        private final int row;

        private final int column;

        private final Ingredient ingredient;
    }

    @RequiredArgsConstructor
    public enum Ingredient {
        MUSHROOM('M'), TOMATO('T');

        private final char symbol;

        public static Ingredient getBySymbol(char typeSymbol) {
            if (typeSymbol == 'M') return MUSHROOM;
            else if (typeSymbol == 'T') return TOMATO;
            else throw new IllegalArgumentException("Unexpected ingredient.");
        }
    }
}

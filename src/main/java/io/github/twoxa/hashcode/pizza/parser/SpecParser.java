package io.github.twoxa.hashcode.pizza.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import io.github.twoxa.hashcode.pizza.Pizza;

class SpecParser {

    Pizza parse(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            final Iterator<String> lineIterator = stream.iterator();
            Pizza pizza = initPizza(lineIterator.next());
            int rows = 0;
            while (lineIterator.hasNext()) {
                String types = lineIterator.next();
                char[] typeSymbols = types.toCharArray();
                for (int i = 0; i < typeSymbols.length; i++) {
                    pizza.getCells()[rows][i] = Pizza.Ingredient.getBySymbol(typeSymbols[i]);
                }
                rows++;
            }
            return pizza;
        } catch (IOException e) {
            throw new RuntimeException("Unexpected exception!", e);
        }
    }

    private Pizza initPizza(String sizes) {
        final String[] values = sizes.split(" ");
        if (values.length != 4) {
            throw new IllegalArgumentException("The provided file does not have a correct format. ");
        }
        int rows = Integer.parseInt(values[0]);
        int columns = Integer.parseInt(values[1]);
        int minOfType = Integer.parseInt(values[2]);
        int maxCells = Integer.parseInt(values[3]);
        return new Pizza(rows, columns, minOfType, maxCells, new Pizza.Ingredient[rows][columns]);
    }
}

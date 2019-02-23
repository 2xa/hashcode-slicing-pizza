package io.github.twoxa.hashcode.pizza.parser;

import static io.github.twoxa.hashcode.pizza.Pizza.Ingredient.MUSHROOM;
import static io.github.twoxa.hashcode.pizza.Pizza.Ingredient.TOMATO;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.twoxa.hashcode.pizza.Pizza;
import org.junit.jupiter.api.Test;

class SpecParserTest {

    private final SpecParser parser = new SpecParser();

    @Test
    void inputCanBeParsed() {
        final Pizza pizza = parser.parse("src/test/resources/a_example.in");
        final int actualRows = pizza.getRows();
        final int actualColumns = pizza.getColumns();
        final int actualMinType = pizza.getMinOfType();
        final int actualMaxCells = pizza.getMaxCells();

        final Pizza.Ingredient[][] actualIngredients = pizza.getCells();

        final Pizza.Ingredient[][] expectedIngredients = {
                {TOMATO, TOMATO, TOMATO, TOMATO, TOMATO},
                {TOMATO, MUSHROOM, MUSHROOM, MUSHROOM, TOMATO},
                {TOMATO, TOMATO, TOMATO, TOMATO, TOMATO},
        };

        assertEquals(3, actualRows);
        assertEquals(5, actualColumns);
        assertEquals(1, actualMinType);
        assertEquals(6, actualMaxCells);
        assertEquals(expectedIngredients.length, actualIngredients.length);

        for (int i = 0; i < actualIngredients.length; i++) {
            Pizza.Ingredient[] actualRow = actualIngredients[i];
            Pizza.Ingredient[] expectedRow = expectedIngredients[i];
            assertArrayEquals(expectedRow, actualRow);
        }
    }

}
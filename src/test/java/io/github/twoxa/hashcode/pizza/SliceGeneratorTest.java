package io.github.twoxa.hashcode.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.twoxa.hashcode.pizza.Pizza.Ingredient.MUSHROOM;
import static io.github.twoxa.hashcode.pizza.Pizza.Ingredient.TOMATO;
import static org.junit.jupiter.api.Assertions.*;

class SliceGeneratorTest {

    private SliceGenerator sliceGenerator;

    @BeforeEach
    void setUp() {
        this.sliceGenerator = new SliceGenerator() {};
    }

    @Test
    void testApply() {
        final List<Slice> slices = this.sliceGenerator.apply(samplePizza());
        assertFalse(slices.isEmpty());
        //assertEquals(3, slices.size());
        //assertEquals(Collections.emptyList(), slices);
    }

    static Pizza samplePizza() {
        //3 5 1 6
        //TTTTT
        //TMMMT
        //TTTTT

        final Pizza.Ingredient[][] cells = {
                {TOMATO, TOMATO, TOMATO, TOMATO, TOMATO},
                {TOMATO, MUSHROOM, MUSHROOM, MUSHROOM, TOMATO},
                {TOMATO, TOMATO, TOMATO, TOMATO, TOMATO}};
        return new Pizza(3, 5, 1, 6, cells);
    }
}
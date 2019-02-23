package io.github.twoxa.hashcode.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SliceGeneratorTest {

    private SliceGenerator sliceGenerator;

    @BeforeEach
    void setUp() {
        this.sliceGenerator = new SliceGenerator() {};
    }

    @Test
    void testApply() {
        assertNotNull(this.sliceGenerator.apply(samplePizza()));
    }

    static Pizza samplePizza() {
        //3 5 1 6
        //TTTTT
        //TMMMT
        //TTTTT

        final char[][] cells = {
                {'T', 'T', 'T', 'T', 'T'},
                {'T', 'M', 'M', 'M', 'T'},
                {'T', 'T', 'T', 'T', 'T'}};
        return new Pizza(3, 5, 1, 6, cells);
    }
}
package io.github.twoxa.hashcode.pizza;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public interface SliceGenerator extends Function<Pizza, List<Slice>> {

    @Override
    default List<Slice> apply(Pizza pizza) {
        return Collections.emptyList();
    }
}

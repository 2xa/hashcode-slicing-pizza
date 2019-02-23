package io.github.twoxa.hashcode.pizza;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SliceGenerator implements Function<Pizza, List<Slice>> {

    @Override
    public List<Slice> apply(Pizza pizza) {
        return pizza.cellStream()
                .flatMap(cell -> slicesForCell(cell, pizza))
                .collect(Collectors.toList());
    }

    private Stream<Slice> slicesForCell(Pizza.Cell cell, Pizza pizza) {
        return IntStream.range(0, pizza.getMaxCells())
                .mapToObj(endRow -> IntStream.range(0, pizza.getMaxCells() - endRow)
                        .mapToObj(endColumn -> new Slice(cell.getRow(), cell.getColumn(), endRow, endColumn)))
                .flatMap(Function.identity())
                .filter(pizza::test);
    }
}

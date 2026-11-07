package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(value -> !value.isEmpty() && Character.isUpperCase(value.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>(list);

            for (Integer value : evenValues) {
                if (value % 2 == 0) {
                    list.add(value);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .filter(s -> s.endsWith("."))
                .filter(s -> s.split("\\s+").length > 3)
                .collect(Collectors.toList());    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}

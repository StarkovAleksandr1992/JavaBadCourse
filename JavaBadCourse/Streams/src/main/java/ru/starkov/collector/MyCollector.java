package ru.starkov.collector;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collector;

public class MyCollector {

    static <T, R> Collector<T, ?, Optional<R>> minMax(Comparator<? super T> comparator, BiFunction<? super T, ? super T, ? extends R> finisher) {
        Objects.requireNonNull(comparator);
        Objects.requireNonNull(finisher);
        class Acc {
            T min;
            T max;
            boolean present;

            void add(T element) {
                if (present) {
                    if (comparator.compare(element, max) > 0) {
                        max = element;
                    } else if (comparator.compare(element, min) < 0) {
                        min = element;
                    }
                } else {
                    min = max = element;
                    present = true;
                }
            }

            Acc combine(Acc other) {
                if (!this.present) {
                    return other;
                }
                if (!other.present) {
                    return this;
                }
                if (comparator.compare(this.min, other.min) > 0) {
                    this.min = other.min;
                }
                if (comparator.compare(this.max, other.max) < 0) {
                    this.max = other.max;
                }
                return this;
            }
        }
        return Collector.of(Acc::new,
                Acc::add,
                Acc::combine,
                acc -> acc.present ? Optional.of(finisher.apply(acc.min, acc.max)) : Optional.empty());
    }

    static <T, R> Collector <T, ?, Optional<R>> minAvgMax(Comparator<? super T> comparator,
                                                          BiFunction<? super T, ? super T, ? extends R> finisher) {
        Objects.requireNonNull(comparator);
        Objects.requireNonNull(finisher);

        class Accumulator {
            T min;
            T avg;
            T max;


        }
        return null;
    }
}

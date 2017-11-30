package com.cegeka.junit5;

import com.google.common.collect.Streams;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class PropertyBasedTestingTest {

    @Test
    void name() {
        assertThat(true).isTrue();
    }

    @ParameterizedTest
    @MethodSource("doubleThrowProvider")
    void spare(DoubleThrow doubleThrow) {
        BowlingGame game = new BowlingGame();

        assumingThat(doubleThrow.firstThrow < 10 && doubleThrow.sum() == 10,
                () -> {
                    game.roll(doubleThrow.firstThrow);
                    game.roll(doubleThrow.secondThrow);
                    assertThat(game.spareWasRolled()).isTrue();
                }
        );
    }

    static Stream<DoubleThrow> doubleThrowProvider() {
        Stream<Integer> firstThrowStream = IntStream.rangeClosed(0, 10).boxed();
        Stream<Integer> secondThrowStream = IntStream.rangeClosed(0, 10).boxed();
        return Streams.zip(firstThrowStream, secondThrowStream, DoubleThrow::doubleThrow);
    }

    private static class DoubleThrow {
        private int firstThrow;
        private int secondThrow;

        private DoubleThrow(int firstThrow, int secondThrow) {
            this.firstThrow = firstThrow;
            this.secondThrow = secondThrow;
        }

        public static DoubleThrow doubleThrow(int firstThrow, int secondThrow) {
            return new DoubleThrow(firstThrow, secondThrow);
        }

        public int getFirstThrow() {
            return firstThrow;
        }

        public int getSecondThrow() {
            return secondThrow;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DoubleThrow that = (DoubleThrow) o;
            return firstThrow == that.firstThrow &&
                    secondThrow == that.secondThrow;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstThrow, secondThrow);
        }

        public int sum() {
            return firstThrow + secondThrow;
        }
    }
}

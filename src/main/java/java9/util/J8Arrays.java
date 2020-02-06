/*
 * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package java9.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;

import java9.util.concurrent.ForkJoinPool;
import java9.util.function.BinaryOperator;
import java9.util.function.DoubleBinaryOperator;
import java9.util.function.IntBinaryOperator;
import java9.util.function.IntFunction;
import java9.util.function.IntToDoubleFunction;
import java9.util.function.IntToLongFunction;
import java9.util.function.IntUnaryOperator;
import java9.util.function.LongBinaryOperator;
import java9.util.stream.DoubleStream;
import java9.util.stream.IntStream;
import java9.util.stream.LongStream;
import java9.util.stream.Stream;
import java9.util.stream.StreamSupport;

/**
 * A place for static default implementations of the new Java 8
 * parallel methods of the {@link java.util.Arrays} class. 
 */
public final class J8Arrays {
    /**
     * Returns a {@link Spliterator} covering all of the specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param <T> type of elements
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static <T> Spliterator<T> spliterator(T[] array) {
        return Spliterators.spliterator(array,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator} covering the specified range of the
     * specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param <T> type of elements
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfInt} covering all of the specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfInt spliterator(int[] array) {
        return Spliterators.spliterator(array,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfInt} covering the specified range of the
     * specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfLong} covering all of the specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @return the spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfLong spliterator(long[] array) {
        return Spliterators.spliterator(array,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfLong} covering the specified range of the
     * specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfDouble} covering all of the specified
     * array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @return a spliterator for the array elements
     * @since 1.8
     */
    public static Spliterator.OfDouble spliterator(double[] array) {
        return Spliterators.spliterator(array,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }

    /**
     * Returns a {@link Spliterator.OfDouble} covering the specified range of
     * the specified array.
     *
     * <p>The spliterator reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
     * {@link Spliterator#IMMUTABLE}.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a spliterator for the array elements
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive,
                                        Spliterator.ORDERED | Spliterator.IMMUTABLE);
    }
    /**
     * Returns a sequential {@link Stream} with the specified array as its
     * source.
     *
     * @param <T> The type of the array elements
     * @param array The array, assumed to be unmodified during use
     * @return a {@code Stream} for the array
     * @since 1.8
     */
    public static <T> Stream<T> stream(T[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link Stream} with the specified range of the
     * specified array as its source.
     *
     * @param <T> the type of the array elements
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code Stream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link IntStream} with the specified array as its
     * source.
     *
     * @param array the array, assumed to be unmodified during use
     * @return an {@code IntStream} for the array
     * @since 1.8
     */
    public static IntStream stream(int[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link IntStream} with the specified range of the
     * specified array as its source.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return an {@code IntStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link LongStream} with the specified array as its
     * source.
     *
     * @param array the array, assumed to be unmodified during use
     * @return a {@code LongStream} for the array
     * @since 1.8
     */
    public static LongStream stream(long[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link LongStream} with the specified range of the
     * specified array as its source.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code LongStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return StreamSupport.longStream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Returns a sequential {@link DoubleStream} with the specified array as its
     * source.
     *
     * @param array the array, assumed to be unmodified during use
     * @return a {@code DoubleStream} for the array
     * @since 1.8
     */
    public static DoubleStream stream(double[] array) {
        return stream(array, 0, array.length);
    }

    /**
     * Returns a sequential {@link DoubleStream} with the specified range of the
     * specified array as its source.
     *
     * @param array the array, assumed to be unmodified during use
     * @param startInclusive the first index to cover, inclusive
     * @param endExclusive index immediately past the last index to cover
     * @return a {@code DoubleStream} for the array range
     * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
     *         negative, {@code endExclusive} is less than
     *         {@code startInclusive}, or {@code endExclusive} is greater than
     *         the array size
     * @since 1.8
     */
    public static DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return StreamSupport.doubleStream(spliterator(array, startInclusive, endExclusive), false);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(byte[] a) {
        DualPivotQuicksort.sort(a, 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(byte[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(char[] a) {
        DualPivotQuicksort.sort(a, 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(char[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(short[] a) {
        DualPivotQuicksort.sort(a, 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(short[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(int[] a) {
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(int[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(long[] a) {
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(long[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p>The {@code <} relation does not provide a total order on all float
     * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
     * {@code 0.0f} and {@code Float.NaN} is considered greater than any
     * other value and all {@code Float.NaN} values are considered equal.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(float[] a) {
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p>The {@code <} relation does not provide a total order on all float
     * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
     * {@code 0.0f} and {@code Float.NaN} is considered greater than any
     * other value and all {@code Float.NaN} values are considered equal.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(float[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    /**
     * Sorts the specified array into ascending numerical order.
     *
     * <p>The {@code <} relation does not provide a total order on all double
     * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
     * {@code 0.0d} and {@code Double.NaN} is considered greater than any
     * other value and all {@code Double.NaN} values are considered equal.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     *
     * @since 1.8
     */
    public static void parallelSort(double[] a) {
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), 0, a.length);
    }

    /**
     * Sorts the specified range of the array into ascending numerical order.
     * The range to be sorted extends from the index {@code fromIndex},
     * inclusive, to the index {@code toIndex}, exclusive. If
     * {@code fromIndex == toIndex}, the range to be sorted is empty.
     *
     * <p>The {@code <} relation does not provide a total order on all double
     * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
     * value compares neither less than, greater than, nor equal to any value,
     * even itself. This method uses the total order imposed by the method
     * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
     * {@code 0.0d} and {@code Double.NaN} is considered greater than any
     * other value and all {@code Double.NaN} values are considered equal.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a Dual-Pivot Quicksort by
     * Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch. This algorithm
     * offers O(n log(n)) performance on all data sets, and is typically
     * faster than traditional (one-pivot) Quicksort implementations.
     *
     * @param a the array to be sorted
     * @param fromIndex the index of the first element, inclusive, to be sorted
     * @param toIndex the index of the last element, exclusive, to be sorted
     *
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > a.length}
     *
     * @since 1.8
     */
    public static void parallelSort(double[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    /**
     * Checks that {@code fromIndex} and {@code toIndex} are in
     * the range and throws an exception if they aren't.
     */
    private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    /**
     * A comparator that implements the natural ordering of a group of
     * mutually comparable elements. May be used when a supplied
     * comparator is null. To simplify code-sharing within underlying
     * implementations, the compare method only declares type Object
     * for its second argument.
     *
     * Arrays class implementor's note: It is an empirical matter
     * whether ComparableTimSort offers any performance benefit over
     * TimSort used with this comparator.  If not, you are better off
     * deleting or bypassing ComparableTimSort.  There is currently no
     * empirical case for separating them for parallel sorting, so all
     * public Object parallelSort methods use the same comparator
     * based implementation.
     */
    static final class NaturalOrder implements Comparator<Object> {
        @SuppressWarnings("unchecked")
        public int compare(Object first, Object second) {
            return ((Comparable<Object>) first).compareTo(second);
        }
        static final NaturalOrder INSTANCE = new NaturalOrder();
    }

    /**
     * The minimum array length below which a parallel sorting
     * algorithm will not further partition the sorting task. Using
     * smaller sizes typically results in memory contention across
     * tasks that makes parallel speedups unlikely.
     */
    private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;

    /**
     * Sorts the specified array of objects into ascending order, according
     * to the {@linkplain Comparable natural ordering} of its elements.
     * All elements in the array must implement the {@link Comparable}
     * interface.  Furthermore, all elements in the array must be
     * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
     * not throw a {@code ClassCastException} for any elements {@code e1}
     * and {@code e2} in the array).
     *
     * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
     * not be reordered as a result of the sort.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a parallel sort-merge that breaks the
     * array into sub-arrays that are themselves sorted and then merged. When
     * the sub-array length reaches a minimum granularity, the sub-array is
     * sorted using the appropriate {@link java.util.Arrays#sort(Object[]) Arrays.sort}
     * method. If the length of the specified array is less than the minimum
     * granularity, then it is sorted using the appropriate {@link
     * java.util.Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a
     * working space no greater than the size of the original array. The
     * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
     * execute any parallel tasks.
     *
     * @param <T> the class of the objects to be sorted
     * @param a the array to be sorted
     *
     * @throws ClassCastException if the array contains elements that are not
     *         <i>mutually comparable</i> (for example, strings and integers)
     * @throws IllegalArgumentException (optional) if the natural
     *         ordering of the array elements is found to violate the
     *         {@link Comparable} contract
     *
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void parallelSort(T[] a) {
        int n = a.length, p, g;
        if (n <= MIN_ARRAY_SORT_GRAN ||
            (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
            TimSort.sort(a, 0, n, NaturalOrder.INSTANCE, null, 0, 0);
        else
            new ArraysParallelSortHelpers.FJObject.Sorter<T>
                (null, a,
                 (T[])Array.newInstance(a.getClass().getComponentType(), n),
                 0, n, 0, ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
                 MIN_ARRAY_SORT_GRAN : g, NaturalOrder.INSTANCE).invoke();
    }

    /**
     * Sorts the specified range of the specified array of objects into
     * ascending order, according to the
     * {@linkplain Comparable natural ordering} of its
     * elements.  The range to be sorted extends from index
     * {@code fromIndex}, inclusive, to index {@code toIndex}, exclusive.
     * (If {@code fromIndex==toIndex}, the range to be sorted is empty.)  All
     * elements in this range must implement the {@link Comparable}
     * interface.  Furthermore, all elements in this range must be <i>mutually
     * comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
     * {@code ClassCastException} for any elements {@code e1} and
     * {@code e2} in the array).
     *
     * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
     * not be reordered as a result of the sort.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a parallel sort-merge that breaks the
     * array into sub-arrays that are themselves sorted and then merged. When
     * the sub-array length reaches a minimum granularity, the sub-array is
     * sorted using the appropriate {@link java.util.Arrays#sort(Object[]) Arrays.sort}
     * method. If the length of the specified array is less than the minimum
     * granularity, then it is sorted using the appropriate {@link
     * java.util.Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a working
     * space no greater than the size of the specified range of the original
     * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
     * used to execute any parallel tasks.
     *
     * @param <T> the class of the objects to be sorted
     * @param a the array to be sorted
     * @param fromIndex the index of the first element (inclusive) to be
     *        sorted
     * @param toIndex the index of the last element (exclusive) to be sorted
     * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
     *         (optional) if the natural ordering of the array elements is
     *         found to violate the {@link Comparable} contract
     * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
     *         {@code toIndex > a.length}
     * @throws ClassCastException if the array contains elements that are
     *         not <i>mutually comparable</i> (for example, strings and
     *         integers).
     *
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>>
    void parallelSort(T[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex, p, g;
        if (n <= MIN_ARRAY_SORT_GRAN ||
            (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
            TimSort.sort(a, fromIndex, toIndex, NaturalOrder.INSTANCE, null, 0, 0);
        else
            new ArraysParallelSortHelpers.FJObject.Sorter<T>
                (null, a,
                 (T[])Array.newInstance(a.getClass().getComponentType(), n),
                 fromIndex, n, 0, ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
                 MIN_ARRAY_SORT_GRAN : g, NaturalOrder.INSTANCE).invoke();
    }

    /**
     * Sorts the specified array of objects according to the order induced by
     * the specified comparator.  All elements in the array must be
     * <i>mutually comparable</i> by the specified comparator (that is,
     * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
     * for any elements {@code e1} and {@code e2} in the array).
     *
     * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
     * not be reordered as a result of the sort.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a parallel sort-merge that breaks the
     * array into sub-arrays that are themselves sorted and then merged. When
     * the sub-array length reaches a minimum granularity, the sub-array is
     * sorted using the appropriate {@link java.util.Arrays#sort(Object[]) Arrays.sort}
     * method. If the length of the specified array is less than the minimum
     * granularity, then it is sorted using the appropriate {@link
     * java.util.Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a
     * working space no greater than the size of the original array. The
     * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
     * execute any parallel tasks.
     *
     * @param <T> the class of the objects to be sorted
     * @param a the array to be sorted
     * @param cmp the comparator to determine the order of the array.  A
     *        {@code null} value indicates that the elements'
     *        {@linkplain Comparable natural ordering} should be used.
     * @throws ClassCastException if the array contains elements that are
     *         not <i>mutually comparable</i> using the specified comparator
     * @throws IllegalArgumentException (optional) if the comparator is
     *         found to violate the {@link java.util.Comparator} contract
     *
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T> void parallelSort(T[] a, Comparator<? super T> cmp) {
        if (cmp == null)
            cmp = NaturalOrder.INSTANCE;
        int n = a.length, p, g;
        if (n <= MIN_ARRAY_SORT_GRAN ||
            (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
            TimSort.sort(a, 0, n, cmp, null, 0, 0);
        else
            new ArraysParallelSortHelpers.FJObject.Sorter<T>
                (null, a,
                 (T[])Array.newInstance(a.getClass().getComponentType(), n),
                 0, n, 0, ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
                 MIN_ARRAY_SORT_GRAN : g, cmp).invoke();
    }

    /**
     * Sorts the specified range of the specified array of objects according
     * to the order induced by the specified comparator.  The range to be
     * sorted extends from index {@code fromIndex}, inclusive, to index
     * {@code toIndex}, exclusive.  (If {@code fromIndex==toIndex}, the
     * range to be sorted is empty.)  All elements in the range must be
     * <i>mutually comparable</i> by the specified comparator (that is,
     * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
     * for any elements {@code e1} and {@code e2} in the range).
     *
     * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
     * not be reordered as a result of the sort.
     *
     * <p><b>Implementation Note:</b><br> The sorting algorithm is a parallel sort-merge that breaks the
     * array into sub-arrays that are themselves sorted and then merged. When
     * the sub-array length reaches a minimum granularity, the sub-array is
     * sorted using the appropriate {@link java.util.Arrays#sort(Object[]) Arrays.sort}
     * method. If the length of the specified array is less than the minimum
     * granularity, then it is sorted using the appropriate {@link
     * java.util.Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a working
     * space no greater than the size of the specified range of the original
     * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
     * used to execute any parallel tasks.
     *
     * @param <T> the class of the objects to be sorted
     * @param a the array to be sorted
     * @param fromIndex the index of the first element (inclusive) to be
     *        sorted
     * @param toIndex the index of the last element (exclusive) to be sorted
     * @param cmp the comparator to determine the order of the array.  A
     *        {@code null} value indicates that the elements'
     *        {@linkplain Comparable natural ordering} should be used.
     * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
     *         (optional) if the natural ordering of the array elements is
     *         found to violate the {@link Comparable} contract
     * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
     *         {@code toIndex > a.length}
     * @throws ClassCastException if the array contains elements that are
     *         not <i>mutually comparable</i> (for example, strings and
     *         integers).
     *
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T> void parallelSort(T[] a, int fromIndex, int toIndex,
                                        Comparator<? super T> cmp) {
        rangeCheck(a.length, fromIndex, toIndex);
        if (cmp == null)
            cmp = NaturalOrder.INSTANCE;
        int n = toIndex - fromIndex, p, g;
        if (n <= MIN_ARRAY_SORT_GRAN ||
            (p = ForkJoinPool.getCommonPoolParallelism()) == 1)
            TimSort.sort(a, fromIndex, toIndex, cmp, null, 0, 0);
        else
            new ArraysParallelSortHelpers.FJObject.Sorter<T>
                (null, a,
                 (T[])Array.newInstance(a.getClass().getComponentType(), n),
                 fromIndex, n, 0, ((g = n / (p << 2)) <= MIN_ARRAY_SORT_GRAN) ?
                 MIN_ARRAY_SORT_GRAN : g, cmp).invoke();
    }

    /**
     * Set all elements of the specified array, using the provided
     * generator function to compute each element.
     *
     * <p>If the generator function throws an exception, it is relayed to
     * the caller and the array is left in an indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, using a generator function to compute
     * each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .forEach(i -> array[i] = generator.apply(i));
     * }</pre>
     *
     * @param <T> type of elements of the array
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.apply(i);
        }
    }

    /**
     * Set all elements of the specified array, in parallel, using the
     * provided generator function to compute each element.
     *
     * <p>If the generator function throws an exception, an unchecked exception
     * is thrown from {@code parallelSetAll} and the array is left in an
     * indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, in parallel, using a generator function
     * to compute each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .parallel()
     *          .forEach(i -> array[i] = generator.apply(i));
     * }</pre>
     *
     * @param <T> type of elements of the array
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static <T> void parallelSetAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(i -> { array[i] = generator.apply(i); });
    }

    /**
     * Set all elements of the specified array, using the provided
     * generator function to compute each element.
     *
     * <p>If the generator function throws an exception, it is relayed to
     * the caller and the array is left in an indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, using a generator function to compute
     * each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .forEach(i -> array[i] = generator.applyAsInt(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void setAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsInt(i);
        }
    }

    /**
     * Set all elements of the specified array, in parallel, using the
     * provided generator function to compute each element.
     *
     * <p>If the generator function throws an exception, an unchecked exception
     * is thrown from {@code parallelSetAll} and the array is left in an
     * indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, in parallel, using a generator function
     * to compute each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .parallel()
     *          .forEach(i -> array[i] = generator.applyAsInt(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     * value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void parallelSetAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(i -> { array[i] = generator.applyAsInt(i); });
    }

    /**
     * Set all elements of the specified array, using the provided
     * generator function to compute each element.
     *
     * <p>If the generator function throws an exception, it is relayed to
     * the caller and the array is left in an indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, using a generator function to compute
     * each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .forEach(i -> array[i] = generator.applyAsLong(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void setAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsLong(i);
        }
    }

    /**
     * Set all elements of the specified array, in parallel, using the
     * provided generator function to compute each element.
     *
     * <p>If the generator function throws an exception, an unchecked exception
     * is thrown from {@code parallelSetAll} and the array is left in an
     * indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, in parallel, using a generator function
     * to compute each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .parallel()
     *          .forEach(i -> array[i] = generator.applyAsLong(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void parallelSetAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(i -> { array[i] = generator.applyAsLong(i); });
    }

    /**
     * Set all elements of the specified array, using the provided
     * generator function to compute each element.
     *
     * <p>If the generator function throws an exception, it is relayed to
     * the caller and the array is left in an indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, using a generator function to compute
     * each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .forEach(i -> array[i] = generator.applyAsDouble(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void setAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsDouble(i);
        }
    }

    /**
     * Set all elements of the specified array, in parallel, using the
     * provided generator function to compute each element.
     *
     * <p>If the generator function throws an exception, an unchecked exception
     * is thrown from {@code parallelSetAll} and the array is left in an
     * indeterminate state.
     *
     * <p><b>API Note:</b><br>
     * Setting a subrange of an array, in parallel, using a generator function
     * to compute each element, can be written as follows:
     * <pre>{@code
     * IntStreams.range(startInclusive, endExclusive)
     *          .parallel()
     *          .forEach(i -> array[i] = generator.applyAsDouble(i));
     * }</pre>
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     */
    public static void parallelSetAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(i -> { array[i] = generator.applyAsDouble(i); });
    }

    // Parallel prefix

    /**
     * Cumulates, in parallel, each element of the given array in place,
     * using the supplied function. For example if the array initially
     * holds {@code [2, 1, 0, 3]} and the operation performs addition,
     * then upon return the array holds {@code [2, 3, 3, 6]}.
     * Parallel prefix computation is usually more efficient than
     * sequential loops for large arrays.
     *
     * @param <T> the class of the objects in the array
     * @param array the array, which is modified in-place by this method
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static <T> void parallelPrefix(T[] array, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        if (array.length > 0)
            new ArrayPrefixHelpers.CumulateTask<>
                    (null, op, array, 0, array.length).invoke();
    }

    /**
     * Performs {@link #parallelPrefix(Object[], BinaryOperator)}
     * for the given subrange of the array.
     *
     * @param <T> the class of the objects in the array
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > array.length}
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static <T> void parallelPrefix(T[] array, int fromIndex,
                                          int toIndex, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new ArrayPrefixHelpers.CumulateTask<>
                    (null, op, array, fromIndex, toIndex).invoke();
    }

    /**
     * Cumulates, in parallel, each element of the given array in place,
     * using the supplied function. For example if the array initially
     * holds {@code [2, 1, 0, 3]} and the operation performs addition,
     * then upon return the array holds {@code [2, 3, 3, 6]}.
     * Parallel prefix computation is usually more efficient than
     * sequential loops for large arrays.
     *
     * @param array the array, which is modified in-place by this method
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(long[] array, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0)
            new ArrayPrefixHelpers.LongCumulateTask
                    (null, op, array, 0, array.length).invoke();
    }

    /**
     * Performs {@link #parallelPrefix(long[], LongBinaryOperator)}
     * for the given subrange of the array.
     *
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > array.length}
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(long[] array, int fromIndex,
                                      int toIndex, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new ArrayPrefixHelpers.LongCumulateTask
                    (null, op, array, fromIndex, toIndex).invoke();
    }

    /**
     * Cumulates, in parallel, each element of the given array in place,
     * using the supplied function. For example if the array initially
     * holds {@code [2.0, 1.0, 0.0, 3.0]} and the operation performs addition,
     * then upon return the array holds {@code [2.0, 3.0, 3.0, 6.0]}.
     * Parallel prefix computation is usually more efficient than
     * sequential loops for large arrays.
     *
     * <p> Because floating-point operations may not be strictly associative,
     * the returned result may not be identical to the value that would be
     * obtained if the operation was performed sequentially.
     *
     * @param array the array, which is modified in-place by this method
     * @param op a side-effect-free function to perform the cumulation
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(double[] array, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0)
            new ArrayPrefixHelpers.DoubleCumulateTask
                    (null, op, array, 0, array.length).invoke();
    }

    /**
     * Performs {@link #parallelPrefix(double[], DoubleBinaryOperator)}
     * for the given subrange of the array.
     *
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > array.length}
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(double[] array, int fromIndex,
                                      int toIndex, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new ArrayPrefixHelpers.DoubleCumulateTask
                    (null, op, array, fromIndex, toIndex).invoke();
    }

    /**
     * Cumulates, in parallel, each element of the given array in place,
     * using the supplied function. For example if the array initially
     * holds {@code [2, 1, 0, 3]} and the operation performs addition,
     * then upon return the array holds {@code [2, 3, 3, 6]}.
     * Parallel prefix computation is usually more efficient than
     * sequential loops for large arrays.
     *
     * @param array the array, which is modified in-place by this method
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(int[] array, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0)
            new ArrayPrefixHelpers.IntCumulateTask
                    (null, op, array, 0, array.length).invoke();
    }

    /**
     * Performs {@link #parallelPrefix(int[], IntBinaryOperator)}
     * for the given subrange of the array.
     *
     * @param array the array
     * @param fromIndex the index of the first element, inclusive
     * @param toIndex the index of the last element, exclusive
     * @param op a side-effect-free, associative function to perform the
     * cumulation
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException
     *     if {@code fromIndex < 0} or {@code toIndex > array.length}
     * @throws NullPointerException if the specified array or function is null
     * @since 1.8
     */
    public static void parallelPrefix(int[] array, int fromIndex,
                                      int toIndex, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex)
            new ArrayPrefixHelpers.IntCumulateTask
                    (null, op, array, fromIndex, toIndex).invoke();
    }

    /**
     * Returns an array containing all of the elements in the passed collection,
     * using the provided {@code generator} function to allocate the returned array.
     *
     * <p>If the passed collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.
     *
     * <p><b>API Note:</b><br>
     * This method acts as a bridge between array-based and collection-based APIs.
     * It allows creation of an array of a particular runtime type. Use
     * {@link Collection#toArray()} to create an array whose runtime type is
     * {@code Object[]}, or use {@link Collection#toArray(Object[]) Collection.toArray(T[])}
     * to reuse an existing array.
     *
     * <p>Suppose {@code x} is a collection known to contain only strings.
     * The following code can be used to dump the collection into a newly
     * allocated array of {@code String}:
     *
     * <pre>
     *     String[] y = J8Arrays.toArray(x, String[]::new);</pre>
     *
     * <p><b>Implementation Requirements:</b><br>
     * The default implementation calls the generator function with zero
     * and then passes the resulting array to {@link Collection#toArray(Object[])
     * Collection.toArray(T[])}.
     *
     * @param <T> the component type of the array to contain the collection
     * @param col the collection to work on
     * @param generator a function which produces a new array of the desired
     *                  type and the provided length
     * @return an array containing all of the elements in the passed collection
     * @throws ArrayStoreException if the runtime type of any element in the
     *         passed collection is not assignable to the {@linkplain Class#getComponentType
     *         runtime component type} of the generated array
     * @throws NullPointerException if the collection or the generator function is null
     * @since 11
     */
    public static <T> T[] toArray(Collection<T> col, IntFunction<T[]> generator) {
        return col.toArray(generator.apply(0));
    }

    private J8Arrays() {
    }
}

package org.james.guava.c8;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangesDemo {

  public static void main(String... args) {

    Range validNum1 = Range.open(1, 10); // (1..10)
    Range validNum2 = Range.openClosed(11, 20); // (11..20]
    Range validNum3 = Range.closedOpen(21, 30); // [21, 30)
    Range validNum4 = Range.closed(31, 40); // [31, 40];

    Range.greaterThan(0); // (0..+∞)
    Range.atLeast(0); // [0..+∞)
    Range.lessThan(0); // (-∞..0)
    Range.atMost(0); // (-∞..0]
    Range.all(); // (-∞..+∞)

    RangeSet rangeSet = TreeRangeSet.create();
    rangeSet.add(validNum1);
    rangeSet.add(validNum2);
    rangeSet.add(validNum3);
    rangeSet.add(validNum4);

    System.out.println(rangeSet.contains(3));
    System.out.println(rangeSet.contains(10));

    Range validNum5 = Range.downTo(1, BoundType.CLOSED);
    Range validNum6 = Range.upTo(1, BoundType.OPEN);
    Range validNum7 = Range.range(1, BoundType.OPEN, 10, BoundType.CLOSED);

    System.out.println(validNum5 + " " + validNum6 + " " + validNum7);

    // 查询运算
    Range.closedOpen(4, 4).isEmpty(); // returns true
    Range.openClosed(4, 4).isEmpty(); // returns true
    Range.closed(4, 4).isEmpty(); // returns false
    //Range.open(4, 4).isEmpty(); // Range.open throws IllegalArgumentException
    Range.closed(3, 10).lowerEndpoint(); // returns 3
    Range.open(3, 10).lowerEndpoint(); // returns 3
    Range.closed(3, 10).lowerBoundType(); // returns CLOSED
    Range.open(3, 10).upperBoundType(); // returns OPEN

    // 关系运算
    System.out.println(Range.closed(1, 10).encloses(Range.closed(2, 4)));

    // 相连[isConnected]
    Range.closed(3, 5).isConnected(Range.open(5, 10)); // returns true
    Range.closed(0, 9).isConnected(Range.closed(3, 4)); // returns true
    Range.closed(0, 5).isConnected(Range.closed(3, 9)); // returns true
    Range.open(3, 5).isConnected(Range.open(5, 10)); // returns false
    Range.closed(1, 5).isConnected(Range.closed(6, 10)); // returns false

    // 交集[intersection]
    Range.closed(3, 5).intersection(Range.open(5, 10)); // returns (5, 5]
    Range.closed(0, 9).intersection(Range.closed(3, 4)); // returns [3, 4]
    Range.closed(0, 5).intersection(Range.closed(3, 9)); // returns [3, 5]
    //Range.open(3, 5).intersection(Range.open(5, 10)); // throws IAE
    //Range.closed(1, 5).intersection(Range.closed(6, 10)); // throws IAE

    // 跨区间[span]
    // 返回”同时包括两个区间的最小区间”，如果两个区间相连，那就是它们的并集。
    Range.closed(3, 5).span(Range.open(5, 10)); // returns [3, 10)
    Range.closed(0, 9).span(Range.closed(3, 4)); // returns [0, 9]
    Range.closed(0, 5).span(Range.closed(3, 9)); // returns [0, 9]
    Range.open(3, 5).span(Range.open(5, 10)); // returns (3, 10)
    Range.closed(1, 5).span(Range.closed(6, 10)); // returns [1, 10]
  }
}

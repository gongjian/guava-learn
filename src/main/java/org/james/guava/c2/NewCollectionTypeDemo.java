package org.james.guava.c2;

import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;
import java.util.Arrays;

/**
 * 新集合类型
 */
public class NewCollectionTypeDemo {

  public static void main(String... args) {
    // Multiset
    Multiset<String> wordMultiset = HashMultiset.create();
    wordMultiset.add("a");
    wordMultiset.add("b");
    wordMultiset.add("a");
    wordMultiset.add("c");
    wordMultiset.add("b");
    wordMultiset.add("a");
    wordMultiset.add("d", 4);

    wordMultiset.remove("d");

    wordMultiset.setCount("a", 2, 4);

    for (String key : wordMultiset.elementSet()) {
      System.out.println(key + ": " + wordMultiset.count(key));
    }

    // MultiMap
    Multimap<String, String> multimap = HashMultimap.create();
    multimap.put("1", "a");
    multimap.putAll("1", Arrays.asList("b", "c"));

    System.out.println(multimap);
    System.out.println(multimap.entries());
    System.out.println(multimap.keys());
    System.out.println(multimap.keySet());

    // BiMap
    BiMap<String, Integer> biMap = HashBiMap.create();
    biMap.put("a", 1);
    biMap.put("b", 2);
    biMap.put("c", 3);

    System.out.println(biMap);
    System.out.println(biMap.inverse());

    try {
      biMap.put("d", 1);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }

    // Table
    Table<Integer, Integer, String> table = HashBasedTable.create();
    table.put(0, 0, "a");
    table.put(0, 1, "b");
    table.put(1, 0, "c");
    table.put(1, 1, "d");

    System.out.println(table);

    System.out.println(table.row(0));
    System.out.println(table.column(1));

    // ClassToInstanceMap
    ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
    numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
    numberDefaults.putInstance(Long.class, Long.valueOf(0));
    System.out.println(numberDefaults);

    // RangeSet
    RangeSet<Integer> rangeSet = TreeRangeSet.create();
    rangeSet.add(Range.closed(1, 10)); // {[1,10]}
    System.out.println("RangeSet");
    System.out.println(rangeSet);
    rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
    System.out.println(rangeSet);
    rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
    System.out.println(rangeSet);
    rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
    System.out.println(rangeSet);
    rangeSet.remove(Range.open(5, 10)); //分割[1, 10]; {[1,5], [10,10], [11,20)}
    System.out.println(rangeSet);

    System.out.println(rangeSet.contains(13));
    System.out.println(rangeSet.contains(20));

    // RangeMap
    RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
    rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
    rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
    rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
    rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
    System.out.println(rangeMap);

    System.out.println(rangeMap.get(4));

  }
}

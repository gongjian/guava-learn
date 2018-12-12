package org.james.guava.c2;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

  public static void main(String... args) {
    // static method
    List<String> list = Lists.newArrayList();
    Map<String, String> map = Maps.newHashMap();
    List<String> list1 = Lists.newArrayListWithCapacity(1);
    List<String> list2 = Lists.newArrayListWithExpectedSize(1);
    List<String> list3 = Lists.newArrayList("a", "b", "c");

    /*guava new type*/
    Multiset<String> set = HashMultiset.create();

    // Iterable
    Iterable<Integer> concatIterable = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(4, 5, 6));
    System.out.println(Iterables.getFirst(concatIterable, "a"));
    System.out.println(Iterables.getLast(concatIterable));
    /*只能是单元素*/
    //System.out.println(Iterables.getOnlyElement(concatIterable));

    // Sets
    Set<String> wordsWithPrimeLength = ImmutableSet
        .of("1", "2", "3", "6", "7", "8");
    Set<String> primes = ImmutableSet.of("2", "3", "5", "7");
    /*交集*/
    SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
    /*并集*/
    SetView<String> union = Sets.union(primes, wordsWithPrimeLength);
    /*差集*/
    SetView<String> difference = Sets.difference(primes, wordsWithPrimeLength);
    SetView<String> difference1 = Sets.difference(wordsWithPrimeLength, primes);
    SetView<String> symmetricDifference = Sets.symmetricDifference(primes, wordsWithPrimeLength);
    System.out.println(intersection.immutableCopy());
    System.out.println(union);
    System.out.println(difference);
    System.out.println(difference1);
    System.out.println(symmetricDifference);

    Set<String> animals = ImmutableSet.of("gerbil", "hamster");
    Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

    /*笛卡尔积*/
    Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
    System.out.println(product);
    // {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
    //  {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}

    /*集合的所有子集*/
    Set<Set<String>> animalSets = Sets.powerSet(animals);
    for (Set<String> s : animalSets) {
      System.out.println(s);
    }

    ImmutableMap<Integer, String> im = Maps
        .uniqueIndex(Lists.newArrayList("a", "bb", "ccc"), input -> input.length());
    System.out.println(im);

    Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3, "d", 5);
    Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 4, "c", 3, "e", 6);
    MapDifference<String, Integer> diff = Maps.difference(left, right);

    System.out.println(diff.entriesInCommon()); // {a=1, c=3}
    System.out.println(diff.entriesDiffering()); // {b=(2, 4)}
    System.out.println(diff.entriesOnlyOnLeft()); // {d=5}
    System.out.println(diff.entriesOnlyOnRight()); // {e=6}

    // Multiset
    Multiset<String> multiset1 = HashMultiset.create();
    multiset1.add("a", 2);

    Multiset<String> multiset2 = HashMultiset.create();
    multiset2.add("a", 5);

    System.out.println(multiset1.containsAll(multiset2)); //返回true；因为包含了所有不重复元素，虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"
    System.out.println(Multisets.containsOccurrences(multiset1, multiset2)); // returns false

    multiset2.removeAll(multiset1);//multiset2移除所有"a"，虽然multiset1只有2个"a"
    System.out.println(multiset2);
    System.out.println(multiset2.isEmpty()); // returns true

    Multiset<String> multiset = HashMultiset.create();
    multiset.add("a", 3);
    multiset.add("b", 5);
    multiset.add("c", 1);

    ImmutableMultiset highestCountFirst = Multisets.copyHighestCountFirst(multiset);
    System.out.println(highestCountFirst);//highestCountFirst，包括它的entrySet和elementSet，按{"b", "a", "c"}排列元素

    // Multimaps
    ImmutableListMultimap immutableListMultimap = Multimaps.index(ImmutableList.of("a", "bb", "cc"), input -> input.length());
    System.out.println(immutableListMultimap);

    ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
    multimap.putAll("b", Ints.asList(2, 4, 6));
    multimap.putAll("a", Ints.asList(4, 2, 1));
    multimap.putAll("c", Ints.asList(2, 5, 3));

    TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.create());
    System.out.println(inverse);
    //注意我们选择的实现，因为选了TreeMultimap，得到的反转结果是有序的
    /*
     * inverse maps:
     *  1 => {"a"}
     *  2 => {"a", "b", "c"}
     *  3 => {"c"}
     *  4 => {"a", "b"}
     *  5 => {"c"}
     *  6 => {"b"}
     */

    Map<String, Integer> mapp = ImmutableMap.of("a", 1, "b", 1, "c", 2);
    SetMultimap<String, Integer> multimapp = Multimaps.forMap(mapp);
    // multimap：["a" => {1}, "b" => {1}, "c" => {2}]
    Multimap<Integer, String> inverse1 = Multimaps.invertFrom(multimapp, HashMultimap.create());
    System.out.println(inverse1);
    // inverse：[1 => {"a","b"}, 2 => {"c"}]
  }
}

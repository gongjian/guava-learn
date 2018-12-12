package org.james.guava.c4;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;

public class FunctionPredicateDemo {

  public static void main(String... args) {
    List<String> list = Lists.newArrayList("a", "ab", "c");
    Iterable<String> result = Iterables.filter(list, Predicates.containsPattern("a"));
    //Iterable<String> result = Iterables.filter(list, input -> input.equals("a"));

    System.out.println(result);
  }

}

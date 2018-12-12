package org.james.guava.c2;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;
import java.util.List;

public class CollectionExtendDemo {

  public static void main(String... args) {

    //扩展ForwardingList
    AddLoggingList<String> loggingList = new AddLoggingList<>();
    loggingList.add("aaa");

    System.out.println(loggingList);
    System.out.println(loggingList.get(0));
    System.out.println(loggingList.getLog(0));

    //
    List<String> result = Lists.newArrayList();
    PeekingIterator<String> iter = Iterators.peekingIterator(Lists.newArrayList("a", "a", "b", "b", "c", "c", "c").iterator());
    while (iter.hasNext()) {
      String current = iter.next();

      while (iter.hasNext() && current.equals(iter.peek())) {
        current = iter.next();
      }

      result.add(current);
    }

    System.out.println(result);

    //AbstractIterator
    Iterator iterator = CollectionExtendDemo.skipNulls(result.iterator());

    // AbstractSequentialIterator
    Iterator<Integer> powersOfTwo = new AbstractSequentialIterator<Integer>(1) { // 注意初始值1!
      protected Integer computeNext(Integer previous) {
        return (previous == 1 << 30) ? null : previous * 2;
      }
    };
  }

  public static Iterator<String> skipNulls(final Iterator<String> in) {
    return new AbstractIterator<String>() {
      protected String computeNext() {
        while (in.hasNext()) {
          String s = in.next();
          if (s != null) {
            return s;
          }
        }
        return endOfData();
      }
    };
  }

}

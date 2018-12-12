package org.james.guava.c2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合
 *
 */
public class ImmutableDemo {

  public static void main(String... args) {

    //JDK
    List<String> list = Lists.newArrayList();
    list.add("a");
    list.add("b");
    list.add("c");

    System.out.println(list);

    List<String> unmodifiableList = Collections.unmodifiableList(list);
    System.out.println(unmodifiableList);

    list.add("d");
    System.out.println("list added a item: " + list);
    System.out.println("list added a item: " + unmodifiableList);

    try {
      unmodifiableList.add("d");
    } catch (UnsupportedOperationException e) {
      System.out.println(e.toString());
    }

    //Guava
    ImmutableList<String> immutableList = ImmutableList.copyOf(list);
    ImmutableList<String> immutableList1 = ImmutableList.of("a", "b", "c", "d");
    ImmutableList<String> immutableList2 = ImmutableList.<String>builder().add("a").build();
    System.out.println("immutableList: " + immutableList);
    System.out.println("immutableList1: " + immutableList1);
    System.out.println("immutableList2: " + immutableList2);

    list.add("e");
    System.out.println("immutableList after list add a item: " + immutableList);

  }

}

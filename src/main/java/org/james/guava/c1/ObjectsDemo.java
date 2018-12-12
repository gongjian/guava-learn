package org.james.guava.c1;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectsDemo {

  /**
   * 重用Object方法
   */
  public static void main(String... args) {

    //equals
    System.out.println(Objects.equal("a", "a"));
    System.out.println(Objects.equal("a", null));
    System.out.println(Objects.equal(null, "a"));
    System.out.println(Objects.equal(null, null));

    //hashcode
    System.out.println(Objects.hashCode("1"));

    //toString
    System.out.println(MoreObjects.toStringHelper("SampleClass").
        add("a", 1).add("b", "b").toString());

    //compare/compareTo
    List<Person> personList = Lists.newArrayList();
    personList.add(new Person("a", "b", 1));
    personList.add(new Person("c", "d", 2));
    personList.add(new Person("b", "c", 1));

    System.out.printf("before sort %s\n", personList.toString());
    Collections.sort(personList);
    System.out.printf("after sort %s", personList.toString());
  }
}

package org.james.guava.c1;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.sun.tools.corba.se.idl.constExpr.Or;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class OrderingDemo {

  public static void main(String... args) {
    List<String> stringList = Lists.newArrayList();
    stringList.add("bbbbb");
    stringList.add("ddddd");
    stringList.add("aaaaa");
    stringList.add("vvvvv");
    stringList.add("eeeee");
    stringList.add("mmmmm");
    stringList.add("rrrrr");

    System.out.printf("stringList %s \n", stringList);

    Ordering<String> natural = Ordering.natural();
    Ordering<Object> usingToString = Ordering.usingToString();
    Ordering<Object> arbitrary = Ordering.arbitrary();

    System.out.printf("natural: %s \n", natural.sortedCopy(stringList));
    System.out.printf("usingToString: %s \n", usingToString.sortedCopy(stringList));
    System.out.printf("arbitrary: %s \n", arbitrary.sortedCopy(stringList));

    Ordering<Integer> orderingBig = new Ordering<Integer>() {
      @Override
      public int compare(@Nullable Integer left, @Nullable Integer right) {
        return left - right;
      }
    };

    List<Integer> integerList = Lists.newArrayList();
    integerList.add(3);
    integerList.add(4);
    integerList.add(5);
    integerList.add(7);
    integerList.add(2);
    integerList.add(9);
    integerList.add(8);
    integerList.add(1);
    integerList.add(0);
    integerList =  orderingBig.sortedCopy(integerList);
    System.out.printf("interList: %s", integerList);
  }

}

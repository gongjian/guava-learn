package org.james.guava.c1;

import com.google.common.base.Optional;

public class OptionalDemo {

  /**
   * 使用和避免null
   *
   * @param args
   */
  public static void main(String... args) {
    Optional<Integer> possible = Optional.of(5);
    System.out.println(possible.isPresent());
    System.out.println(possible.get());

    Optional<String> nullObj = Optional.absent();
    System.out.println(nullObj.isPresent());
    System.out.println(nullObj.or("default"));
    System.out.println(nullObj.orNull());

    Optional<String> str = Optional.fromNullable(null);
    System.out.println(str.isPresent());

    possible.orNull();

  }
}

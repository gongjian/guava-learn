package org.james.guava.c1;

import com.google.common.base.Preconditions;

public class PreconditonsDemo {

  /**
   * 前置条件
   *
   * @param args
   */
  public static void main(String... args) {
    Preconditions.checkArgument(true);
    Preconditions.checkNotNull(1);
    Preconditions.checkState(4 > 3);
    Preconditions.checkPositionIndex(3,2);
  }
}

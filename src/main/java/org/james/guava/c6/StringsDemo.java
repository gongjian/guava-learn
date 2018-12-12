package org.james.guava.c6;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Arrays;

public class StringsDemo {

  /**
   * https://github.com/google/guava/wiki/StringsExplained
   *
   * @param args
   */
  public static void main(String... args) {
    // 连接器
    Joiner joiner = Joiner.on("; ").skipNulls();
    Joiner joiner1 = Joiner.on("; ").useForNull("*");
    String ret = joiner.join("a", null, "b", null, "c");
    String ret1 = joiner1.join(Arrays.asList(1, 2, 3, null, 4));

    System.out.println(ret);
    System.out.println(ret1);

    // 拆分器
    Iterable<String> iter = Splitter.fixedLength(3).split("abcdefghijklmnopqrstuvwxyz");
    System.out.println(iter);

    // 字符匹配器
    //System.out.println(CharMatcher.digit().retainFrom("ab12c"));

    // 大小写格式化
    String s = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
    System.out.println(s);


  }

}
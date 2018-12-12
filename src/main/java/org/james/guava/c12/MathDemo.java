package org.james.guava.c12;

import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import java.math.RoundingMode;

public class MathDemo {

  public static void main(String[] args) {

    // 溢出检查
    //IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE);

    // 实数运算
    System.out.println(IntMath.divide(9, 4, RoundingMode.HALF_DOWN));

    // 浮点数运算
    System.out.println(DoubleMath.roundToInt(2.5, RoundingMode.HALF_UP));

  }

}

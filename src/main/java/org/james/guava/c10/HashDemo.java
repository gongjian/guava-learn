package org.james.guava.c10;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HashDemo {

  public static void main(String[] args) {
    String input = "hello, world";

    @SuppressWarnings("unchecked")
    HashFunction hf = Hashing.md5();
    HashCode hashCode = hf.newHasher().putString(input, Charsets.UTF_8).hash();
    System.out.println(hashCode.toString());

    //System.out.println(Hashing.md5().hashString(input, Charsets.UTF_8).toString());
  }
}

package org.james.guava.c1;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

class Person implements Comparable<Person> {

  public String firstName;
  public String lastName;
  public int age;

  Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  @Override
  public int compareTo(Person o) {
    return ComparisonChain.start().compare(this.firstName, o.firstName)
        .compare(this.lastName, o.lastName)
        .compare(this.age, o.age).result();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("firstName", this.firstName)
        .add("lastName", this.lastName).add("age", this.age).toString();
  }
}

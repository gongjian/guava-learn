package org.james.guava.c3;

import com.google.common.base.MoreObjects;

public class Employee {

  private String id;
  private String name;
  private Integer age;

  public Employee() {
  }

  public Employee(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
  }
}

package org.james.guava.c2;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;
import java.util.List;

public class AddLoggingList<E> extends ForwardingList<E> {

  final List<E> delegate = Lists.newArrayList();
  final List<String> logList = Lists.newArrayList();

  @Override
  protected List<E> delegate() {
    return delegate;
  }

  @Override
  public boolean add(E element) {
    logList.add("log added element - " + element);
    return super.add(element);
  }

  @Override
  public String toString() {
    return "AddLoggingList{" +
        "delegate=" + delegate +
        ", logList=" + logList +
        '}';
  }

  public String getLog(int index) {
    return logList.get(index);
  }
}

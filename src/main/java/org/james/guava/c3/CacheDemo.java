package org.james.guava.c3;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDemo {

  static LoadingCache<String, Employee> cache = CacheBuilder.newBuilder().maximumSize(10)
      .expireAfterAccess(3,
          TimeUnit.SECONDS).recordStats().build(createCacheLoader());

  public static CacheLoader<String, Employee> createCacheLoader() {
    return new CacheLoader<String, Employee>() {
      @Override
      public Employee load(String key) throws Exception {
        return new Employee(key, UUID.randomUUID().toString());
      }
    };
  }

  public static void main(String... args) throws ExecutionException {
    System.out.println(CacheDemo.cache.getIfPresent("P001"));
    System.out.println(CacheDemo.cache.get("P001"));
    System.out.println(CacheDemo.cache.get("P001"));

    System.out.println(CacheDemo.cache.size());
    System.out.println(CacheDemo.cache.stats().loadCount());
    System.out.println(CacheDemo.cache.stats().hitRate());
  }


}

集合[Collections]
Guava对JDK集合的扩展，这是Guava最成熟和为人所知的部分

2.1 不可变集合: 用不变的集合进行防御性编程和性能提升。

ImmutableList.copyOf(list)
ImmutableList.of("a", "b", "c", "d")
ImmutableList.<String>builder().add("a").build()

2.2 新集合类型: multisets, multimaps, tables, bidirectional maps等

wordMultiset.add("d", 4)
wordMultiset.remove("d")
wordMultiset.setCount("a", 2, 4)

multimap.put("1", "a")
multimap.putAll("1", Arrays.asList("b", "c"))

TreeRangeSet.create()
Range.closedOpen(11, 15)
Range.openClosed(0, 0)
Range.open(5, 10)
Range.closed(1, 2)
rangeSet.contains(13)

TreeRangeMap.create()

2.3 强大的集合工具类: 提供java.util.Collections中没有的集合工具

SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
Sets.union(primes, wordsWithPrimeLength)
Sets.difference(primes, wordsWithPrimeLength)
Sets.symmetricDifference(primes, wordsWithPrimeLength)

Sets.cartesianProduct(animals, fruits)

2.4 扩展工具类：让实现和扩展集合类变得更容易，比如创建Collection的装饰器，或实现迭代器
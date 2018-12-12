函数式风格[Functional idioms]

注意事项
截至JDK7，Java中也只能通过笨拙冗长的匿名类来达到近似函数式编程的效果。预计JDK8中会有所改变，但Guava现在就想给JDK5以上用户提供这类支持。

过度使用Guava函数式编程会导致冗长、混乱、可读性差而且低效的代码。这是迄今为止最容易（也是最经常）被滥用的部分，如果你想通过函数式风格达成一行代码，致使这行代码长到荒唐，Guava团队会泪流满面。
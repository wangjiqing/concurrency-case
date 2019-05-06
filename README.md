# Java 并发编程

1. [标记线程安全注解](src/main/java/com/sakura/concurrencycase/annotation/ThreadSafe.java)
2. [标记线程不安全注解](src/main/java/com/sakura/concurrencycase/annotation/NotThreadSafe.java)
3. [标记推荐的类或者写法](src/main/java/com/sakura/concurrencycase/annotation/Recommend.java)
4. [标记不推荐的类或者写法](src/main/java/com/sakura/concurrencycase/annotation/NotRecommend.java)
5. [测试并发访问初体验使用controller](src/main/java/com/sakura/concurrencycase/controller/TestController.java)
6. [线程不安全的代码一](src/main/java/com/sakura/concurrencycase/ConcurrencyTest.java)
7. [使用Atomic改造线程不安全的代码实现](src/main/java/com/sakura/concurrencycase/example/count/CountExample2.java)
8. [使用LongAdder改造线程不安全的代码实现](src/main/java/com/sakura/concurrencycase/example/atomic/AtomicExample3.java)
9. [使用AtomicReference实例](src/main/java/com/sakura/concurrencycase/example/atomic/AtomicExample4.java)
10. [使用AtomicIntegerFieldUpdater实例](src/main/java/com/sakura/concurrencycase/example/atomic/AtomicExample5.java)
11. [使用AtomicLongArray实例](src/main/java/com/sakura/concurrencycase/example/atomic/AtomicExample6.java)
12. [使用AtomicBoolean实例](src/main/java/com/sakura/concurrencycase/example/atomic/AtomicExample7.java)
13. [使用Synchronized实例 - 修饰代码块 & 方法](src/main/java/com/sakura/concurrencycase/example/sync/SynchronizedExample1.java)
14. [使用Synchronized实例 - 修饰静态方法 & 类](src/main/java/com/sakura/concurrencycase/example/sync/SynchronizedExample2.java)
15. [使用Synchronized改造线程不安全的代码实现](src/main/java/com/sakura/concurrencycase/example/count/CountExample3.java)
16. [使用volatile改造线程不安全的代码实现 - 证明依旧线程不安全](src/main/java/com/sakura/concurrencycase/example/count/CountExample4.java)
17. [线程不安全发布一个对象示例](src/main/java/com/sakura/concurrencycase/example/publish/UnsafePublish.java)
18. [模拟对象逸出示例（线程不安全），不推荐的写法](src/main/java/com/sakura/concurrencycase/example/publish/Escape.java)
19. [懒汉式单例模式：单例实例会在第一次调用的时候创建](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample1.java)
20. [饿汉式单例模式：单例实例会在类装载的时候创建](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample2.java)
21. [不推荐的改造: 懒汉式单例模式](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample3.java)
22. [双重检验锁改造（线程不安全）：懒汉式单例模式](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample4.java)
23. [双重校验锁+volatile改造（线程安全）：懒汉式单例模式](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample5.java)
24. [使用静态代码块改造：饿汉式单例模式](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample6.java)
25. [使用枚举类实现单例模式：推荐、线程安全](src/main/java/com/sakura/concurrencycase/example/singleton/SingletonExample7.java)
26. [final关键字修饰变量](src/main/java/com/sakura/concurrencycase/example/immutable/ImmutableExample1.java)
27. [ThreadLocal在Spring Boot项目中的应用](src/main/java/com/sakura/concurrencycase/example/threadLocal/RequestHolder.java)
28. [StringBuilder线程不安全的实现](src/main/java/com/sakura/concurrencycase/example/commonUnSafe/StringExample1.java)
29. [StringBuffer线程安全的实现](src/main/java/com/sakura/concurrencycase/example/commonUnSafe/StringExample2.java)
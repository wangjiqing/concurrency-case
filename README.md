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
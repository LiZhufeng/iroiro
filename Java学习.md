# Java基本知识学习

## 一、NIO Selector

背景：学习多线程并发的时候，了解到线程interrupt之后，会有两种不一样的结果：
从线程本身的中断方法（比如Sleep）方法出来的话，这个标记还是false。

但是如果从NIO Selector中出来的话，这个标记就是true的。

所以需要学习看下NIO Selector这个是做什么的。

博客：https://www.cnblogs.com/snailclimb/p/9086334.html

## 二、ConcurrentLinkedQueue
CAS算法：线程安全的插入队列

这个看代码也是一脸懵逼。。还是继续学习下吧

博客：http://ifeve.com/concurrentlinkedqueue/
补充：ConcurrentHashMap的学习博客：http://www.importnew.com/28263.html
可以先学习一下红黑树

## 三、线程安全相关知识
### 1、闭锁：CountDownLatch 的两个方法：await和countDown
源码分析：https://blog.csdn.net/chenssy/article/details/49794141
### 2、FutureTask
源码分析：https://blog.csdn.net/xxxzhi/article/details/51453438
### 3、Samphere，数据库连接池
acquire、release：源码看一下
### 4、栅栏，CylicBarrier
实现一组线程的同时唤醒

这些都看完，可以理解下这个：
实战：通过ConcurrentMap、FutureTask、putIfAbsent来实现高效的结果存储队列

## 四、并发线程，执行任务
### 1、 CompletionService：结合了Executor和BlockingQueue的方法

这周能看完这些已经很不错了。。。

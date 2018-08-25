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

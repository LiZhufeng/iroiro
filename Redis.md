# Redis 学习
## 字典结构
### 目前遗留的问题
1、murmurhash 算法，生成尽量随机的哈希值的原理
https://111qqz.com/2017/03/murmurhash%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/
https://paper.seebug.org/180/

2、哈希表在进行扩展/收缩过程的时候，如果要插入数据会进行什么处理

3、hset key field value 这种map的数据结构和字典有什么关联？
key---value 也应该有一个地方来管理的吧？
难道key 是字典名称，field --- value 才是键值对？


# Netty Benchmark

## 代码说明
1. src/main/java包下的的代码：NettyServer.java和ServerHandler.java是服务端代码，其具体实现功能是接收客户端发送的数据并返回。  
NettyClient.java和ClientHandler.java是测试连接以及echo功能是否正常的代码，而并非压测代码。压测代码参见[这里](https://github.com/kasicass/fatbench)的echo_cleint.py。

2. NettyServer默认启动两个线程组，每个线程组线程数是1，而Netty的实现是当前运行CPU核数的二倍。可以通过参数来修改。

3. 开放端口号为25000
## 关于编译
工程是由idea创建的maven工程，可以使用maven来编译。也可使用`javac`命令来编译，使用`javac`命令编译时，要添加Netty的依赖包，例如：
```jshelllanguage
javac -classpath netty-all-4.1.6.Final.jar -d ./ ./*.java
```

## 关于运行
1. 自行编译的，可以使用`java`命令来执行，注意要在classpath变量中增加netty-*.jar的相关引用

2. 工程out目录下有可执行jar包，可以通过命令下面命令来运行。
```jshelllanguage
java -classpath nettybenchmark.jar com.keshawn.NettyServer 
```



package ConDemo;

//并发工具类
//处理异步任务
//Future：用于异步任务的结果获取，但不支持回调。
//CompletableFuture：增强版 Future，支持异步回调、流式处理。
//使用异步编程实现链式调用

import java.util.concurrent.CompletableFuture;

public class ConDemo_5 {
    public static void main(String[] args){
        CompletableFuture.supplyAsync(() -> "Hello,World!")// ① 异步执行任务，返回字符串
                .thenApply(String::toUpperCase)// ② 处理结果（转换为大写）
                .thenAccept(System.out::println);// ③ 处理最终结果（打印到控制台）
    }
}

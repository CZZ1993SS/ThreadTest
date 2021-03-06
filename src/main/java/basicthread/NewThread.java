package basicthread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author czz
 * 创建线程的三种方式以及基本使用方法
 */
public class NewThread {

    /**
     * 方式一: 扩展自Thread类
     */
    private static class ThreadBasic extends Thread{

        @Override
        public void run(){

            System.out.println("----- 开始 ThreadBasic 的工作 -----");

        }

    }


    /**
     * 方式二: 实现Runnable接口
     * （单继承多实现）
     */
    private static class ThreadRunnable implements Runnable{

        @Override
        public void run() {

            System.out.println("----- 开始 ThreadRunnable 的工作 -----");

        }

    }


    /**
     * 方式三: 实现Callable接口,允许有返回值
     */
    private static class ThreadCallable implements Callable<String>{

        @Override
        public String call() throws Exception {

            System.out.println("----- 开始 ThreadCallable 的工作 -----");

            return "ThreadCallable result";

        }
    }


    public static void main(String[] args) throws Exception{

        /*Thread*/
        new ThreadBasic().start();

        /*Runnable*/
        new Thread(new ThreadRunnable()).start();

        /*Callable*/
        FutureTask<String> futureTask = new FutureTask<String>(new ThreadCallable());
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);

        /*直接调用 run 只会被当前线程当成普通方法调用放在主线程上跑，只有通过 start 装配映射成实际的内存中的线程才才会真正具有多线程的特性*/

    }





}

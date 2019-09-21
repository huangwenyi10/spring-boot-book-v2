package com.example.demo.shutdown;

/**
 * 描述：java优雅关闭
 * @author Ay
 * @create 2019/09/01
 **/
public class JavaShutdownTest {

    public static void main(String[] args) {
        System.out.println("step-1: main thread start");
        Thread mainThread = Thread.currentThread();
        //注册一个 ShutdownHook
        ShutdownSampleHook thread=new ShutdownSampleHook(mainThread);
        Runtime.getRuntime().addShutdownHook(thread);
        try {
            //主线程sleep 30s
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            System.out.println("step-3: mainThread get interrupt signal.");
        }
        System.out.println("step-4: main thread end");
    }
}

/**
 * 钩子
 */
class ShutdownSampleHook extends Thread {

    //主线程
    private Thread mainThread;

    @Override
    public void run() {
        System.out.println("step-2: shut down signal received.");
        //给主线程发送一个中断信号
        mainThread.interrupt();
        try {
            //等待 mainThread 正常运行完毕
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("step-5: shut down complete.");
    }

    /**
     * 构造方法
     * @param mainThread
     */
    public ShutdownSampleHook(Thread mainThread) {
        this.mainThread=mainThread;

    }
}

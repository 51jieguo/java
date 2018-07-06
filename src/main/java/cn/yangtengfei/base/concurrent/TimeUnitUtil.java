package cn.yangtengfei.base.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * TimeUnit是java.util.concurrent包下面的一个类，
 * TimeUnit提供了可读性更好的线程暂停操作，通常用来替换Thread.sleep()，
 * 在很长一段时间里Thread的sleep()方法作为暂停线程的标准方式，
 * 几乎所有Java程序员都熟悉它，事实上sleep方法本身也很常用而且出现在很多面试中。
 * 如果你已经使用过Thread.sleep()，当然我确信你这样做过，
 * 那么你一定熟知它是一个静态方法，暂停线程时它不会释放锁，
 * 该方法会抛出InterrupttedException异常（如果有线程中断了当前线程）。
 * 但是我们很多人并没有注意的一个潜在的问题就是它的可读性。
 * Thread.sleep()是一个重载方法，可以接收长整型毫秒和长整型的纳秒参数，
 * 这样对程序员造成的一个问题就是很难知道到底当前线程是睡眠了多少秒、分、小时或者天。
 * 看看下面这个Thread.sleep()方法：
 */
public class TimeUnitUtil {

    public static void main(String[] args) {
        System.out.println("-----------start----------");

        try {
            //TimeUnit.SECONDS.sleep(4);
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------END----------");

    }
}

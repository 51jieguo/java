package cn.yangtengfei.base.aggregation.map;

public class ManyThreadMapThread {

    public static void main(String[] args) {
        MapThread t0 = new MapThread();
        MapThread t1 = new MapThread();
        MapThread t2 = new MapThread();
        MapThread t3 = new MapThread();
        MapThread t4 = new MapThread();
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

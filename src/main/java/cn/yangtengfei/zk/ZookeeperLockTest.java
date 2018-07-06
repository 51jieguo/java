package cn.yangtengfei.zk;

public class ZookeeperLockTest {

    public static void main(String[] args) {
        String config = "localhost:2181,localhost:2182,localhost:2183";
        ZookeeperLock zookeeperLock = new ZookeeperLock(config,"zkLock");

        zookeeperLock.lock();

        //zookeeperLock.unlock();

    }

}

package cn.yangtengfei.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZkTest {

//    private static String url="127.0.0.1:2181";
//    public static void main(String[] args) {
//
//    }


    private static CountDownLatch latch = new CountDownLatch(1);

    public void main(String[] args) throws IOException, KeeperException, InterruptedException {

        ZooKeeper zk = getZk();
        while(true){
            try{
                //zk.create("/testRoot", "testRoot".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                zk.delete("/testRoot",-1);
                System.out.println(zk.toString());
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //zk.create();
    }
    /**
     * 创建zk连接
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static ZooKeeper getZk() throws IOException, InterruptedException{
        //如果是集群，则逗号隔开，比如192.168.0.219:2181,192.168.0.220:2181,192.168.0.221:2181
        String connStr = "localhost:2181,localhost:2182,localhost:2183";
        int session_time = 5000;//每5秒发送一次心跳
        ZooKeeper zk = new ZooKeeper(connStr,session_time,new Watcher(){
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {

                    System.out.println("zk connection OK....");
                    latch.countDown();//释放阻塞

                } else if (event.getState().equals(Event.KeeperState.Disconnected)) {

                    // 这时收到断开连接的消息，这里其实无能为力，因为这时已经和ZK断开连接了，只能等ZK再次开启了
                    System.out.println("zk Disconnected");

                } else if (event.getState().equals(Event.KeeperState.Expired)) {


                    // 这时收到这个信息，表示，ZK已经重新连接上了，但是会话丢失了，这时需要重新建立会话。
                    System.out.println("zk Expired");
                    //这里可以进行zk重新连接操作
                    //do Some thing....
                } else if (event.getState().equals(Event.KeeperState.AuthFailed)) {

                    System.out.println("zk AuthFailed");
                }else {

                    System.out.println("unkonke...." + event.getType());
                }
            }

        });
        System.out.println("zk status=" + zk.getState());
        latch.await(5000,TimeUnit.MILLISECONDS);//阻塞，等待zk连接成功，或者5s超时，否则不能往下执行
        System.out.println("zk connection OK,lock release....");

        return zk;
    }
}

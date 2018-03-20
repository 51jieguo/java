package cn.yangtengfei.base.aggregation.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    static Map<String,String> map = new HashMap<>();
    public static void main(String[] args) {

        //map.put(null,null);
        //map.put("11111111",null);
        //System.out.println(map);
       // System.out.println(1 << 30);
        map.put("12121","12312321");
    }

    public  void showMapToString(){
        System.out.println(map.toString());
    }
}

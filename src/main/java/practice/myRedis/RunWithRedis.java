package practice.myRedis;

import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RunWithRedis {
    public static void main(String[] args) throws InterruptedException {
        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<>(Arrays.asList("1.1.1.1:26379", "1.1.1.1:26379"));
        JedisPoolConfig config = new JedisPoolConfig();

        // 控制一個 pool 可以分配多少個 jedis 的 instance
        // 透過 pool.getResource() 來獲取 instance
        // 不夠的時候會噴 redis.clients.jedis.exceptions.JedisException: Could not get a resource from the pool
        config.setMaxTotal(1);
        config.setMaxIdle(1);
        config.setMaxWaitMillis(3000L);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        String pass = "test";
        RedisService redisService =
                new RedisService(masterName, sentinels, config, pass, 14);

        redisService.put("aaa", "testValue", 5);

        System.out.println("Value : " + redisService.get("aaa"));

        TimeUnit.SECONDS.sleep(5);

        System.out.println("After 5 seconds, Value : " + redisService.get("aaa"));
    }
}

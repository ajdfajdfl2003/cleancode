package practice.myRedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Optional;
import java.util.Set;

public class RedisService {
    private final JedisSentinelPool pool;
    private final int dbIndex;

    public RedisService(String masterName, Set<String> sentinels,
                        JedisPoolConfig config, String password, int dbIndex) {
        this.pool = new JedisSentinelPool(masterName, sentinels, config, password);
        this.dbIndex = dbIndex;
    }

    public void put(String key, String value) {
        try (Jedis jedis = this.pool.getResource()) {
            selectDb(jedis);
            jedis.set(key, value);
        }
    }

    public void put(String key, String value, int expireSeconds) {
        try (Jedis jedis = this.pool.getResource()) {
            selectDb(jedis);
            jedis.set(key, value);
            jedis.expire(key, expireSeconds);
        }
    }

    public Optional<String> get(String key) {
        try (Jedis jedis = this.pool.getResource()) {
            selectDb(jedis);
            return Optional.ofNullable(jedis.get(key));
        }
    }

    public void remove(String key) {
        try (Jedis jedis = this.pool.getResource()) {
            selectDb(jedis);
            jedis.del(key);
        }
    }

    private void selectDb(Jedis jedis) {
        jedis.select(dbIndex);

    }
}

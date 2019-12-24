package com.ly.springdemo.Cache;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {
    private final String id;

    private Jedis cache = new Jedis("127.0.0.1", 6379);

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    // 返回缓存所有键值对的数量
    @Override
    public int getSize() {
        Long dbSize = cache.dbSize();
        return dbSize.intValue();
    }

    // 向缓存中存入数据
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("put object key:" + key);
        System.out.println("put Object value"+ value);
        // 将对象序列化成字节数组
        byte[] keyBs = SerializationUtils.serialize((Serializable) key);
        byte[] valueBs = SerializationUtils.serialize((Serializable) value);
        System.out.println("set object keyBs:" + Arrays.toString(keyBs));
        System.out.println("set Object valueBs"+ Arrays.toString(valueBs));
        cache.set(keyBs, valueBs);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            System.out.println("----- ready to put in redis -----");
//            System.out.println("key:" + key.toString());
//            System.out.println("value:" + value.toString());
//
//            String keyJson = objectMapper.writeValueAsString(key.toString());
//
//            String valueJson = objectMapper.writeValueAsString(value.toString());
//            System.out.println("keyToJson:" + keyJson);
//            System.out.println("valueToJson:" + valueJson);
//            cache.set(keyJson, valueJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

    }

    // 从缓存中获取数据
    @Override
    public Object getObject(Object key) {
        byte[] keyBs = SerializationUtils.serialize((Serializable) key);
        byte[] valueBs = cache.get(keyBs);
        if (valueBs != null) { // 第一次到缓存找数据的时候 , 返回的是null
            return SerializationUtils.deserialize(valueBs);
        }
        return null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            String keyJson = objectMapper.writeValueAsString(key.toString());
//            String valueJson = cache.get(keyJson);
//
//            if (valueJson != null) {
//                Object value = objectMapper.readValue(valueJson,Object.class);
//                System.out.println("value:"+StringUtils.strip(value.toString(),"[]"));
//                return StringUtils.strip(value.toString(),"[]");
//            }
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    // 清除缓存
    @Override
    public Object removeObject(Object key) {
        // 先获取一下删除的对象
        byte[] keyBs = SerializationUtils.serialize((Serializable) key);
        byte[] valueBs = cache.get(keyBs);
        Object obj = SerializationUtils.deserialize(valueBs);
        cache.del(keyBs);// 执行删除操作
        return obj;
    }

    // 清空缓存
    @Override
    public void clear() {
        cache.flushDB();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (getId() == null) {
            throw new CacheException("Cache instances require an ID.");
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cache)) {
            return false;
        }

        Cache otherCache = (Cache) o;
        return getId().equals(otherCache.getId());
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            throw new CacheException("Cache instances require an ID.");
        }
        return getId().hashCode();
    }

    public static void main(String[] args) {
        RedisCache cache = new RedisCache("1");
        cache.clear();
    }
}

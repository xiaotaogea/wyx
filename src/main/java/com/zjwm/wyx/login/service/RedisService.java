package com.zjwm.wyx.login.service;

public interface RedisService {
    /**
     * 设置key-value
     */
    void setKey(String key, String value);

    /**
     * 获取key
     */
    String getValue(String key);

    /**
     * 删除key
     */
    void delete(String key);
}

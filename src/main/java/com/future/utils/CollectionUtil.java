package com.future.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :CollectionUtil
 * 功能概要  :集合工具类
 * 做成日期  :2020-12-01  huangsl
 */
public class CollectionUtil {

    /**
     * @param map 取值的集合
     * @param key 所想取值的集合的key
     * @return 返回key对应的value
     */
    public static String getMapValue(Map<String,Object> map, String key){
        String result = null;
        if(map != null){
            Iterator<String> iterable = map.keySet().iterator();
            while (iterable.hasNext()){
                Object object = iterable.next();
                if(key.equals(object))
                    if(map.get(object) != null)
                        result = map.get(object).toString();
            }
        }

        return result;
    }
}

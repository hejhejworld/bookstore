package com.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 将map的数据封装成一个JavaBean对象
     * @param map
     * @param bean
     * @param <T>
     * @return JavaBean
     */
    public static <T> T copyParamToBean(Map map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * String转int
     * @param strInt
     * @param defaultVal strInt为空时的默认值
     * @return
     */
    public static int parseInt(String strInt, int defaultVal) {
        try {
            if (strInt != null)
                return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultVal;
    }
}

package com.wx.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

public final class TrimUtil {
    public static Object trimObjectStringProperty(Object obj) throws Exception {
        if (Objects.isNull(obj)) {
            return obj;
        }
        Class<?> clazz = obj.getClass();
        if (clazz == Boolean.class || clazz == Integer.class || clazz == Long.class || clazz == Float.class
            || clazz == Double.class || clazz == BigDecimal.class) {
            return obj;
        }
        if (clazz == String.class) {
            return StringUtils.trimToEmpty((String) obj);
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            Object value = field.get(obj);
            if (Objects.nonNull(value) && field.getType() == String.class) {
                field.set(obj, StringUtils.trimToEmpty((String) value));
            }
        }
        return obj;
    }

    public static void trimListStringProperty(List<?> objects) throws Exception {
        if (CollectionUtils.isEmpty(objects)) {
            return;
        }
        for (Object obj : objects) {
            trimObjectStringProperty(obj);
        }
    }
}

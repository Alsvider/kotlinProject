package com.test.kotlinProject.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangch on 2021/7/13.
 */

class Test {
    public final String a="0";

    public static void main(String[] args) throws NoSuchMethodException {
        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        Method method = Test.class.getDeclaredMethod("test", Map.class);
        Type genericReturnType = method.getGenericReturnType();
        checkType(genericReturnType);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
    }


    public static Map<List<String>, Set<Map<Integer,String>>> test(Map<List<String>, Set<Map<Integer,String>>> map){
        return null;
    }

    public static void checkType(Type type){
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                checkType(actualTypeArgument);
            }
        } else {
            System.out.println("type:"+type);
        }
    }
}

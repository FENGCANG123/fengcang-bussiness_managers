package com.neuedu.annotation;

import com.neuedu.pojo.UserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class AnnotationTest {
    public static void main(String[] args) {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("fengcang");
        userInfo.setEmail("fengcang@163.com");
        StringBuffer buffer=new StringBuffer();
        try {
            Class c=Class.forName("com.neuedu.pojo.UserInfo");
           boolean isexistsTanleAnnotation=c.isAnnotationPresent(Table.class);
           if (isexistsTanleAnnotation){
               Table table=(Table)c.getAnnotation(Table.class);
               System.out.println(table.value());
               String str=table.value();
               buffer.append("select * from "+str+" where 1=1 ");
           }
           Field[] fields=c.getDeclaredFields();
            System.out.println(fields.length);
            List<String> names=null;
            for (int i = 0; i <fields.length ; i++) {
                Field f=fields[i];
                boolean isexistsColumnAnnotation=f.isAnnotationPresent(Column.class);
                if (isexistsColumnAnnotation) {
                    Column column = (Column) f.getAnnotation(Column.class);
                    String name=f.getName();
                    name=name.substring(0,1).toUpperCase().concat(name.substring(1));
                    Method method=c.getMethod("get"+name);
                    Class returnType=method.getReturnType();
                    String s=returnType.getName();
                    Object o=method.invoke(userInfo);
                    System.out.println(s);
                    System.out.println(o);
                    System.out.println(name);
                    System.out.println(column.value());
                    if (o!=null)
                    {
                        if (s.equals("java.lang.String"))
                        buffer.append(column.value()+"="+"'"+o+"'"+" and ");
                    }
                }

            }

            String sql=buffer.substring(0,buffer.length()-4);
            System.out.println(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

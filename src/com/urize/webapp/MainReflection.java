package com.urize.webapp;

import com.urize.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume resume = new Resume();
        Field declaredFields = resume.getClass().getDeclaredFields()[0];
        System.out.println(declaredFields.getName());
        declaredFields.setAccessible(true);

        System.out.println(declaredFields.get(resume));
        declaredFields.set(resume, "new uuid");
        System.out.println(resume);

        reflectToString(resume);
        toReflect(resume);
    }

    public static void reflectToString(Object myClass) {
        try {
            Method method = myClass.getClass().getDeclaredMethod("toString");
            method.setAccessible(true);
            Object invoke = method.invoke(myClass);
            System.out.println(invoke);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void toReflect(Object myClass) {
        try {
            Method method = myClass.getClass().getDeclaredMethod("toReflect", int.class);
            method.setAccessible(true);
            method.invoke(myClass, 809);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

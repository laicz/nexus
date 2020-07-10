package com.zhou.haizhi.nexus.spring.proxy.javaassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create by zhoumingbing on 2020-05-21
 */
public class CreatePerson {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool classPool = ClassPool.getDefault();
        //创建一个类，并指定 限定名
        CtClass ctClass = classPool.makeClass("com.zhou.haizhi.nexus.spring.proxy.DynamicPerson");

        //创建字段
        CtField fixPerson = new CtField(classPool.get("com.zhou.haizhi.nexus.spring.proxy.Person"), "fixPerson", ctClass);
        fixPerson.setModifiers(Modifier.PRIVATE);

        ctClass.addField(fixPerson);

        ctClass.addMethod(CtNewMethod.setter("fixPerson",fixPerson));
        ctClass.addMethod(CtNewMethod.getter("fixPerson",fixPerson));

        //自定义一个方法
        CtMethod definitionPerson = new CtMethod(CtClass.voidType, "definitionPerson", new CtClass[]{}, ctClass);
        definitionPerson.setModifiers(Modifier.PUBLIC);
        definitionPerson.setBody("{" +
                "com.zhou.haizhi.nexus.spring.proxy.Person person = new com.zhou.haizhi.nexus.spring.proxy.Person();" +
                "person.setName(\"this is javassit\");" +
                "System.out.println(person);"+
                "}");
        ctClass.addMethod(definitionPerson);

        Object o = ctClass.toClass().newInstance();
        Method definitionPerson1 = o.getClass().getMethod("definitionPerson");
        definitionPerson1.invoke(o);

    }
}

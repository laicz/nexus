package com.zhou.haizhi.nexus.jvm.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Create by zhoumingbing on 2020-04-26
 */
public class Compiler_001 {

    public static void main(String[] args) {
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int run = javaCompiler.run(null,null,null,"-version");
        System.out.println(run);
    }

}

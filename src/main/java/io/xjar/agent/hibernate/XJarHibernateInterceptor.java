package io.xjar.agent.hibernate;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.jar.JarFile;

/**
 * JPA Interceptor
 *
 * @author Payne 646742615@qq.com
 * 2019/1/25 14:46
 */
public class XJarHibernateInterceptor {
    private final ClassLoader classLoader;

    public XJarHibernateInterceptor(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @RuntimeType
    public Object intercept(@Origin Method method, @SuperCall Callable<JarFile> callable) throws Exception {
        JarFile jarFile = callable.call();
        return new XJarFile(jarFile.getName(), classLoader);
    }

}

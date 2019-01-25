package io.xjar.agent.hibernate;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

/**
 * JPA Transformer
 *
 * @author Payne 646742615@qq.com
 * 2019/1/25 14:39
 */
public class XJarHibernateTransformer implements AgentBuilder.Transformer {

    @Override
    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
        return builder.method(ElementMatchers.named("resolveJarFileReference")).intercept(MethodDelegation.to(new XJarHibernateInterceptor(classLoader)));
    }
}

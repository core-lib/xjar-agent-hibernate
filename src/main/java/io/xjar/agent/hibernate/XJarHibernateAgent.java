package io.xjar.agent.hibernate;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * XJar Hibernate Agent
 *
 * @author Payne 646742615@qq.com
 * 2019/1/25 13:06
 */
public class XJarHibernateAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.named("org.hibernate.boot.archive.internal.JarFileBasedArchiveDescriptor"))
                .transform(new XJarHibernateTransformer())
                .installOn(instrumentation);
    }

}

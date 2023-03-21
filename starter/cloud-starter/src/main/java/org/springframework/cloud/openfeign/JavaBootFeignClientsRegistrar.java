package org.springframework.cloud.openfeign;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;

/**
 * Description: feign 自动配置功能 from mica
 *
 * @author iyuLife
 * @date 2023/3/16 14:31
 */
public class JavaBootFeignClientsRegistrar implements ImportBeanDefinitionRegistrar, BeanClassLoaderAware, EnvironmentAware {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}

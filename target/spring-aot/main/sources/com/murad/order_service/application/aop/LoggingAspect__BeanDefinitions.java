package com.murad.order_service.application.aop;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoggingAspect}.
 */
@Generated
public class LoggingAspect__BeanDefinitions {
  /**
   * Get the bean definition for 'loggingAspect'.
   */
  public static BeanDefinition getLoggingAspectBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LoggingAspect.class);
    beanDefinition.setInstanceSupplier(LoggingAspect::new);
    return beanDefinition;
  }
}

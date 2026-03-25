package com.murad.order_service.infrastructure.scheduler.outbox;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OutboxSchedular}.
 */
@Generated
public class OutboxSchedular__BeanDefinitions {
  /**
   * Get the bean definition for 'outboxSchedular'.
   */
  public static BeanDefinition getOutboxSchedularBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OutboxSchedular.class);
    beanDefinition.setInstanceSupplier(OutboxSchedular::new);
    return beanDefinition;
  }
}

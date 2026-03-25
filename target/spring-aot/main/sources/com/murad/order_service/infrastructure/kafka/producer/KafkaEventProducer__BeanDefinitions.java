package com.murad.order_service.infrastructure.kafka.producer;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Bean definitions for {@link KafkaEventProducer}.
 */
@Generated
public class KafkaEventProducer__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'kafkaEventProducer'.
   */
  private static BeanInstanceSupplier<KafkaEventProducer> getKafkaEventProducerInstanceSupplier() {
    return BeanInstanceSupplier.<KafkaEventProducer>forConstructor(KafkaTemplate.class)
            .withGenerator((registeredBean, args) -> new KafkaEventProducer(args.get(0)));
  }

  /**
   * Get the bean definition for 'kafkaEventProducer'.
   */
  public static BeanDefinition getKafkaEventProducerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KafkaEventProducer.class);
    beanDefinition.setInstanceSupplier(getKafkaEventProducerInstanceSupplier());
    return beanDefinition;
  }
}

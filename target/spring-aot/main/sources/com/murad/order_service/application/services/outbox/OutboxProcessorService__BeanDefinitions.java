package com.murad.order_service.application.services.outbox;

import com.murad.order_service.domain.kafka.interfaces.IKafkaEventProducer;
import com.murad.order_service.domain.repository.OutboxRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OutboxProcessorService}.
 */
@Generated
public class OutboxProcessorService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'outboxProcessorService'.
   */
  private static BeanInstanceSupplier<OutboxProcessorService> getOutboxProcessorServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OutboxProcessorService>forConstructor(OutboxRepository.class, IKafkaEventProducer.class)
            .withGenerator((registeredBean, args) -> new OutboxProcessorService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'outboxProcessorService'.
   */
  public static BeanDefinition getOutboxProcessorServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OutboxProcessorService.class);
    beanDefinition.setInstanceSupplier(getOutboxProcessorServiceInstanceSupplier());
    return beanDefinition;
  }
}

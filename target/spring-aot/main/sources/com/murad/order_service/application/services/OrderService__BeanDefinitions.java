package com.murad.order_service.application.services;

import com.murad.order_service.domain.extensions.JsonSerializerExtension;
import com.murad.order_service.domain.mapper.orderMapper.OrderMapper;
import com.murad.order_service.domain.mapper.outboxMapper.OutboxEventMapper;
import com.murad.order_service.domain.repository.OrderRepository;
import com.murad.order_service.domain.repository.OutboxRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrderService}.
 */
@Generated
public class OrderService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'orderService'.
   */
  private static BeanInstanceSupplier<OrderService> getOrderServiceInstanceSupplier() {
    return BeanInstanceSupplier.<OrderService>forConstructor(OrderMapper.class, OrderRepository.class, OutboxRepository.class, OutboxEventMapper.class, JsonSerializerExtension.class)
            .withGenerator((registeredBean, args) -> new OrderService(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'orderService'.
   */
  public static BeanDefinition getOrderServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderService.class);
    beanDefinition.setInstanceSupplier(getOrderServiceInstanceSupplier());
    return beanDefinition;
  }
}

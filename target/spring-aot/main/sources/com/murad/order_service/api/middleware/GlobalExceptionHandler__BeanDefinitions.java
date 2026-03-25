package com.murad.order_service.api.middleware;

import com.murad.order_service.domain.mapper.ApiErrorMapper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GlobalExceptionHandler}.
 */
@Generated
public class GlobalExceptionHandler__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'globalExceptionHandler'.
   */
  private static BeanInstanceSupplier<GlobalExceptionHandler> getGlobalExceptionHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GlobalExceptionHandler>forConstructor(ApiErrorMapper.class)
            .withGenerator((registeredBean, args) -> new GlobalExceptionHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'globalExceptionHandler'.
   */
  public static BeanDefinition getGlobalExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalExceptionHandler.class);
    beanDefinition.setInstanceSupplier(getGlobalExceptionHandlerInstanceSupplier());
    return beanDefinition;
  }
}

package com.murad.order_service.domain.extensions;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import tools.jackson.databind.ObjectMapper;

/**
 * Bean definitions for {@link JsonSerializerExtension}.
 */
@Generated
public class JsonSerializerExtension__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'jsonSerializerExtension'.
   */
  private static BeanInstanceSupplier<JsonSerializerExtension> getJsonSerializerExtensionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JsonSerializerExtension>forConstructor(ObjectMapper.class)
            .withGenerator((registeredBean, args) -> new JsonSerializerExtension(args.get(0)));
  }

  /**
   * Get the bean definition for 'jsonSerializerExtension'.
   */
  public static BeanDefinition getJsonSerializerExtensionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JsonSerializerExtension.class);
    beanDefinition.setInstanceSupplier(getJsonSerializerExtensionInstanceSupplier());
    return beanDefinition;
  }
}

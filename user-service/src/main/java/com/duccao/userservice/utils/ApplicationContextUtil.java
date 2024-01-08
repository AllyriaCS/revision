package com.duccao.userservice.utils;

import com.duccao.userservice.exceptions.TechnicalError;
import com.duccao.userservice.exceptions.TechnicalException;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }

  public static <T> T getSpringBean(final String name, final Class<T> type) {
    try {
      return context.getBean(name, type);
    } catch (Exception exception) {
      throw new TechnicalException(TechnicalError.BEAN_NOT_FOUND);
    }
  }

  public static <T> T getSpringBean(final Class<T> type) {
    try {
      return context.getBean(type);
    } catch (Exception exception) {
      throw new TechnicalException(TechnicalError.BEAN_NOT_FOUND);
    }
  }

  public static <T> Map<String, T> getSpringBeans(final Class<T> type) {
    try {
      return context.getBeansOfType(type);
    } catch (Exception exception) {
      throw new TechnicalException(TechnicalError.BEAN_NOT_FOUND);
    }
  }
}

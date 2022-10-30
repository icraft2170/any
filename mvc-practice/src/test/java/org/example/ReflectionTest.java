package org.example;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Controller 애노테이션이 붙은 모든 클래스를 찾아 출력한다.
 */
public class ReflectionTest {
  private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

  @Test
  void controllerScan() {
    Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));
    logger.debug("beans [{}]", beans);
  }

  @Test
  void showClass() {
    Class<User> clazz = User.class;
    logger.debug(clazz.getName());
    logger.debug("user all declared fields: [{}]",
        Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
    logger.debug("user all declared constructors: [{}]",
        Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
    logger.debug("user all declared methods : [{}]",
        Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
  }

  @Test
  void load() throws ClassNotFoundException {
    Class<User> clazz1 = User.class;

    User user = new User("Hero", "손현호");
    Class<? extends User> clazz2 = user.getClass();

    Class<?> clazz3 = Class.forName("org.example.model.User");

    logger.debug("clazz1 : [{}]", clazz1);
    logger.debug("clazz2 : [{}]", clazz2);
    logger.debug("clazz3 : [{}]", clazz3);

    Assertions.assertThat(clazz1 == clazz2).isTrue();
    Assertions.assertThat(clazz1 == clazz3).isTrue();
    Assertions.assertThat(clazz2 == clazz3).isTrue();
  }

  private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
    Reflections reflections = new Reflections("org.example");
    Set<Class<?>> beans = new HashSet<>();
    annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
    return beans;
  }
}

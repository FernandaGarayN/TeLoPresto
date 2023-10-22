package cl.duoc.newrentacar.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("principal");
    registry.addViewController("/index").setViewName("principal");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/vehiculos").setViewName("vehiculos");
  }
}

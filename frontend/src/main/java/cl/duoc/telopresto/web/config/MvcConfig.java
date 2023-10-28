package cl.duoc.telopresto.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("index");
    registry.addViewController("/index").setViewName("index");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/vehiculos").setViewName("vehiculos");
    registry.addViewController("/contacto").setViewName("contacto");
    registry.addViewController("/requisitos").setViewName("requisitos");
    registry.addViewController("/rrss").setViewName("rrss");
    registry.addViewController("/registro").setViewName("registro");
    registry.addViewController("/recuperar-contrasenia").setViewName("recuperar-contrasenia");
  }
}

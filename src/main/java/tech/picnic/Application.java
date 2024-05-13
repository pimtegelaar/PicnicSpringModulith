package tech.picnic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableWebMvc
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}

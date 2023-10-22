package cl.duoc.telopresto.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients({"cl.duoc.telopresto.web.apiclients"})
public class TeLoPrestoWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeLoPrestoWebApplication.class, args);
    }
}

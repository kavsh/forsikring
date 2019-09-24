package no.forsikring.integrasjonslag;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackages = "no.forsikring")
public class AvtaleApplication {

    public static void main(String[] args) {
        run(AvtaleApplication.class, args);
    }
}

package murat.webapi.restdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Integer integerBean() { return 0;
    }
    @Bean
    public String stringBean() {
        return "Your String Value"; // Replace with the desired string value.
    }
    @Bean
    public java.util.Date currentDate() {
        return new java.util.Date();
    }

    // Other configuration code...
}

package org.alex859.milantransit4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
public class Application
{
   @Bean
   public RestTemplate restTemplate()
   {
      return new RestTemplate();
   }

   public static void main(String[] args)
   {
      SpringApplication.run(Application.class, args);
   }
}

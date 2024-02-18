package com.nix.ybrcrudapp;

import static com.nix.ybrcrudapp.UserService.initUsers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class TestCrudApp {

  public static void main(String[] args) {
    SpringApplication.run(TestCrudApp.class, args);
  }

  @Bean
  public CommandLineRunner sampleData() {
    return (args) -> {
      initUsers();
      System.out.println(args);
    };
  }
}

package com.nix.ybrcrudapp;

import static com.nix.ybrcrudapp.UserService.initUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class YbrCrudAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(YbrCrudAppApplication.class, args);
    initUsers();
  }

}

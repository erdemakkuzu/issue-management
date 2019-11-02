package com.erdemakkuzu.issuemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IssueManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(IssueManagementApplication.class, args);
  }

  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}


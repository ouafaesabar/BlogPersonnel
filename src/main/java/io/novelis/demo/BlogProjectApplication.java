package io.novelis.demo;

import io.novelis.demo.dao.ArticleDao;
import io.novelis.demo.dao.impl.ArticleDaoImpl;
import io.novelis.demo.domain.User;
import io.novelis.demo.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "io.novelis.demo")
public class BlogProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProjectApplication.class, args);
    }

}

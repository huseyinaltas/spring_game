package com.gamenumber.validation;

import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
//        URI dbUri = new URI(System.getenv("DATABASE_URL"));
//        Uri dbUri = Uri.parse("postgres://asfpfqikfntlbf:9dc9246713baf65141e4fc939d63d033adde39cfe49a839b94a973b8e500e8fe@ec2-54-196-89-124.compute-1.amazonaws.com:5432/d5tsq10sc0pt04");

//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
  
    	String username = "asfpfqikfntlbf";
        String password = "9dc9246713baf65141e4fc939d63d033adde39cfe49a839b94a973b8e500e8fe";
        String dbUrl = "jdbc:postgresql://ec2-54-196-89-124.compute-1.amazonaws.com:5432/d5tsq10sc0pt04";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
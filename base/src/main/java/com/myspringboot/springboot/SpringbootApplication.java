package com.myspringboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws Exception{
		// SpringApplication.run(SpringbootApplication.class, args);
		Environment env = SpringApplication.run(SpringbootApplication.class, args).getEnvironment();
        String port = env.getProperty("server.port", "777");
        String host = InetAddress.getLocalHost().getHostAddress();

        System.out.println("\n----------------------------------------------------------");
        System.out.println("Application is running! Access it here:");
        System.out.println("Local:      http://localhost:" + port);
        System.out.println("Codespaces: https://" + host + "-" + port + ".githubpreview.dev");
        System.out.println("----------------------------------------------------------\n");
    }
	

}

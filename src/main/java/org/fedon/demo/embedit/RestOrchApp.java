package org.fedon.demo.embedit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * REST facade application
 * 
 * @author Dmytro Fedonin
 */
@SpringBootApplication
public class RestOrchApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(RestOrchApp.class, args);
    }
}

package org.fedon.demo.embedit;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

/**
 * Spring context test.
 */
public class AppTest 
{
    @Test
    public void applicationContext()
    {
        SpringApplication.run(RestOrchApp.class, "");
    }
}

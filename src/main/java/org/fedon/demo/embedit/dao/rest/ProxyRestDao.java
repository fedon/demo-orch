package org.fedon.demo.embedit.dao.rest;

import org.fedon.demo.embedit.error.RestErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dmytro Fedonin
 */
@Component
public class ProxyRestDao {

    @Autowired
    private RestTemplateBuilder rtb;
    private RestTemplate rt;

    public RestTemplate template() {
        if (rt == null) {
            rt = rtb.errorHandler(new RestErrorHandler()).build();
        }
        return rt;
    }
}

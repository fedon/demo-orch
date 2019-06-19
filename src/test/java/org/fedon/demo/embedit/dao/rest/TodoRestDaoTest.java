package org.fedon.demo.embedit.dao.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.fedon.demo.embedit.model.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dmytro Fedonin
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoRestDaoTest {
    private String url = "testURL";
    private Integer userId = Integer.valueOf(1);

    @Mock
    private ProxyRestDao proxy;
    @InjectMocks
    private TodoRestDao todoDao;

    @Test
    public void listByUserId() throws IllegalAccessException {
        FieldUtils.writeField(todoDao, "url", url, true);
        RestTemplate rt = mock(RestTemplate.class);
        when(proxy.template()).thenReturn(rt);
        when(rt.exchange(url + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {})).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        todoDao.listByUserId(userId);
        verify(rt).exchange(url + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {});
    }
}

package org.fedon.demo.embedit.dao.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.fedon.demo.embedit.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dmytro Fedonin
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRestDaoTest {
    private String url = "testURL";
    private Integer userId = Integer.valueOf(1);

    @Mock
    private ProxyRestDao proxy;
    @InjectMocks
    private UserRestDao userDao;

    @Test
    public void findById() throws IllegalAccessException {
        FieldUtils.writeField(userDao, "url", url, true);
        RestTemplate rt = mock(RestTemplate.class);
        when(proxy.template()).thenReturn(rt);

        userDao.findById(userId);
        verify(rt).getForObject(url + userId, User.class, (Object) null);
    }
}

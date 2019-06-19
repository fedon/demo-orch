package org.fedon.demo.embedit.error;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author Dmytro Fedonin
 */
public class RestErrorHandlerTest {
    RestErrorHandler handler = new RestErrorHandler();

    @Test
    public void hasError_Server() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.BAD_GATEWAY);

        boolean err = handler.hasError(resp);
        assertTrue(err);
    }

    @Test
    public void hasError_Client() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.BAD_REQUEST);

        boolean err = handler.hasError(resp);
        assertTrue(err);
    }

    @Test
    public void hasError_Redirect() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.PERMANENT_REDIRECT);

        boolean err = handler.hasError(resp);
        assertFalse(err);
    }

    @Test
    public void handleError_Client() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.BAD_REQUEST);

        handler.handleError(resp);
    }

    @Test(expected = NotFoundException.class)
    public void handleError_NotFound() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.NOT_FOUND);

        handler.handleError(resp);
    }

    @Test(expected = BrokenPipeException.class)
    public void handleError_Server() throws IOException {
        ClientHttpResponse resp = mock(ClientHttpResponse.class);
        when(resp.getStatusCode()).thenReturn(HttpStatus.BAD_GATEWAY);

        handler.handleError(resp);
    }
}

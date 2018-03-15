package com.ktt;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

public class HttpRequestHeaderInterceptor implements ClientHttpRequestInterceptor {

    private final String headerName;
    private final String headerValue;

    public HttpRequestHeaderInterceptor(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
        requestWrapper.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        requestWrapper.getHeaders().add(headerName, headerValue);
        return execution.execute(requestWrapper, body);
    }
}

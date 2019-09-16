package com.sandra.scd.gate.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: lenovo
 * @Description: 网关熔断器
 * @Date: 2019/7/10 10:08
 **/
@Component
public class GateFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {

        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(final String route, final Throwable cause) {

        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() throws IOException {

                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {

                return 200;
            }

            @Override
            public String getStatusText() throws IOException {

                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {

                return new ByteArrayInputStream("oooops!error, i'm the fallback.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {

                final HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

}

package com.covid19next.client;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public abstract class BaseClient {

    public static String queryParamEncodingBuilder(String title) {
        return UriComponentsBuilder.fromUri(URI.create(title)).encode().toUriString();
    }
}

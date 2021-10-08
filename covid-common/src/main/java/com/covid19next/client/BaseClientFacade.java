package com.covid19next.client;

import java.util.Optional;

public interface BaseClientFacade<T,R> {
    Optional<T> getResponseData(R r);
}

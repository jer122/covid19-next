package com.covid19next.client.covid;

import com.covid19next.client.BaseClient;
import com.covid19next.client.BaseClientFacade;
import com.covid19next.domain.covid.CovidCountriesRequest;
import com.covid19next.domain.covid.CovidCountriesResponse;
import com.covid19next.domain.covid.CovidCountryResponse;
import com.covid19next.exception.RestException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CovidCountriesClient extends BaseClient implements BaseClientFacade<CovidCountryResponse, String> {

    final static String BaseUrl = "https://corona-api.com";

    private HttpClient getHttpClient() {
        return HttpClient.create()
                .tcpConfiguration(tcpClient -> tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 90000))
                .doOnConnected(connection -> connection.addHandlerLast(new ReadTimeoutHandler(5))
                        .addHandlerLast(new WriteTimeoutHandler(60)
                        )
                );
    }

    private static WebClient getWebClient(HttpClient httpClient) {
        return WebClient.builder()
                .baseUrl(BaseUrl)
                .exchangeStrategies(setExchangeStrategies())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    private static ExchangeStrategies setExchangeStrategies() {
        return ExchangeStrategies.builder()
                .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(-1))
                .build();
    }


    //버퍼 사이즈 제한 해제 (-1=unlimited / 10mb = 10*1024*1024)
    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(-1))
            .build();

    public Optional<CovidCountriesResponse> getResponseData() {
        return getWebClient(getHttpClient()).get()
                .uri(uriBuilder -> uriBuilder.path("/countries")
                        .queryParam("include", "timeline")
                        .build()
                )
                .retrieve()
                .onStatus(httpStatus -> httpStatus.is3xxRedirection() || httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(ErrorResponse.class).map(errorResponse -> new RestException(errorResponse.getErrorMessage())))
                .bodyToMono(CovidCountriesResponse.class)
                .blockOptional();
    }

    public Optional<CovidCountryResponse> getResponseData(String code) {
        log.info("CovidCountriesClient ->{}", code);
        return getWebClient(getHttpClient()).get()
                .uri(uriBuilder -> uriBuilder
                        .path("/countries/" + code)
                        .build())
                .retrieve()
                .onStatus(httpStatus -> httpStatus.is3xxRedirection() || httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(ErrorResponse.class)
                                .map(errorResponse -> new RestException(errorResponse.getErrorMessage())
                                )
                )
                .bodyToMono(CovidCountryResponse.class)
                .blockOptional();
    }


    public static void main(String[] args) {
        CovidCountriesClient covidCountriesClient = new CovidCountriesClient();
        Optional<CovidCountriesResponse> responseData = covidCountriesClient.getResponseData();
        log.info("data -> {}", responseData);


    }

    @Data
    @NoArgsConstructor
    public static class ErrorResponse implements JsonSerializable {
        @JsonProperty("message")
        private String errorMessage;

        @Override
        public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {

        }

        @Override
        public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {

        }
    }
}

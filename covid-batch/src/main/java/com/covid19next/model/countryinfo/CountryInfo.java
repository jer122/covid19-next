package com.covid19next.model.countryinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.IOException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryInfo implements JsonSerializable {

    @JsonProperty("currentCount")
    public int currentCount;
    @JsonProperty("data")
    public List<CountryData> data;
    @JsonProperty("numOfRows")
    public int numOfRows;
    @JsonProperty("pageNo")
    public int pageNo;
    @JsonProperty("resultCode")
    public int resultCode;
    @JsonProperty("resultMsg")
    public String resultMsg;
    @JsonProperty("totalCount")
    public int totalCount;

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {

    }
}

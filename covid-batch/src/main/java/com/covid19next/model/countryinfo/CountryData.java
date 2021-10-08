package com.covid19next.model.countryinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class CountryData {
    @JsonProperty("climate_cn")
    public String climate_cn;
    @JsonProperty("country_area")
    public String country_area;
    @JsonProperty("country_area_comment")
    public String country_area_comment;
    @JsonProperty("country_area_src")
    public String country_area_src;
    @JsonProperty("country_cptl_nm")
    public String country_cptl_nm;
    @JsonProperty("country_eng_nm")
    public String country_eng_nm;
    @JsonProperty("country_iso_alp2")
    public String country_iso_alp2;
    @JsonProperty("country_lc")
    public String country_lc;
    @JsonProperty("country_nm")
    public String country_nm;
    @JsonProperty("lang_cn")
    public Object lang_cn;
    @JsonProperty("lang_nm")
    public Object lang_nm;
    @JsonProperty("main_city_cn")
    public String main_city_cn;
    @JsonProperty("main_ethnic_cn")
    public String main_ethnic_cn;
    @JsonProperty("mscmctn_cn")
    public String mscmctn_cn;
    @JsonProperty("religion_cn")
    public String religion_cn;
    @JsonProperty("written_year")
    public int written_year;



    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "CountryData{" +
                "climate_cn='" + climate_cn + '\'' +
                ", country_area='" + country_area + '\'' +
                ", country_area_comment='" + country_area_comment + '\'' +
                ", country_area_src='" + country_area_src + '\'' +
                ", country_cptl_nm='" + country_cptl_nm + '\'' +
                ", country_eng_nm='" + country_eng_nm + '\'' +
                ", country_iso_alp2='" + country_iso_alp2 + '\'' +
                ", country_lc='" + country_lc + '\'' +
                ", country_nm='" + country_nm + '\'' +
                ", lang_cn=" + lang_cn +
                ", lang_nm=" + lang_nm +
                ", main_city_cn='" + main_city_cn + '\'' +
                ", main_ethnic_cn='" + main_ethnic_cn + '\'' +
                ", mscmctn_cn='" + mscmctn_cn + '\'' +
                ", religion_cn='" + religion_cn + '\'' +
                ", written_year=" + written_year +
                '}';

        return mapper.writeValueAsString(json);
    }
}

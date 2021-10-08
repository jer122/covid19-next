package com.covid19next.domain.covidinfo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CovidCountrySafetyNewsListNewResponse implements JsonSerializable {

    @JsonProperty("currentCount")
    private Long currentCount;
    @JsonProperty("data")
    private List<ResponseData> dataList;
    @JsonProperty("numOfRows")
    private Long numOfRows;
    @JsonProperty("pageNo")
    private Long pageNo;
    @JsonProperty("resultCode")
    private Long resultCode;
    @JsonProperty("resultMsg")
    private String resultMsg;
    @JsonProperty("totalCount")
    private Long totalCount;

    @Builder
    public CovidCountrySafetyNewsListNewResponse(Long currentCount, List<ResponseData> dataList, Long numOfRows, Long pageNo, Long resultCode, String resultMsg, Long totalCount) {
        this.currentCount = currentCount;
        this.dataList = dataList;
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.totalCount = totalCount;
    }


    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {

    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {

    }

    @Data
    public static class ResponseData {

        @JsonProperty("continent_cd")
        private String continentCd;
        @JsonProperty("continent_eng_nm")
        private String continentEngNm;
        @JsonProperty("continent_nm")
        private String continentNm;
        @JsonProperty("country_eng_nm")
        private String countryEngNm;
        @JsonProperty("country_iso_alp2")
        private String countryIsoAlp2;
        @JsonProperty("country_nm")
        private String countryNm;
        @JsonProperty("file_cnt")
        private String fileCnt;
        @JsonProperty("file_download_url")
        private String fileDownloadUrl;
        @JsonProperty("file_path")
        private String filePath;
        @JsonProperty("html_origin_cn")
        private String htmlOriginCn;
        @JsonProperty("sfty_notice_id")
        private String sftyNoticeId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("txt_origin_cn")
        private String txtOriginCn;
        @JsonProperty("wrt_dt")
        private Date wrtDt;

        @Builder
        public CovidInformation toEntity() {
            return CovidInformation.builder()
                    .noticeId(sftyNoticeId)
                    .infoType(InfoType.ETC)
                    .title(title)
                    .content(htmlOriginCn)
                    .wrtDt(wrtDt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                    .code(countryIsoAlp2)
                    .continentEngName(continentEngNm)
                    .continentName(continentNm)
                    .countryName(countryNm)
                    .countryEngName(countryEngNm)
                    .filePath(filePath)
                    .fileUrl(fileDownloadUrl)
                    .build();
        }
    }
}

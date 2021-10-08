package com.covid19next.model.covidinfo;

import com.covid19next.model.OpenAPIServiceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpenAPIServiceResponseTest {


    @Test
    public void mockTest() {
        OpenAPIServiceResponse openAPIServiceResponse = new OpenAPIServiceResponse();
        OpenAPIServiceResponse.CmmMsgHeader cmmMsgHeader = new OpenAPIServiceResponse.CmmMsgHeader();
        cmmMsgHeader.setErrMsg("test");
        cmmMsgHeader.setReturnAuthMsg("return Msg");
        openAPIServiceResponse.setCmmMsgHeader(cmmMsgHeader);


        System.out.println(openAPIServiceResponse.getCmmMsgHeader().getReturnAuthMsg());


    }

}
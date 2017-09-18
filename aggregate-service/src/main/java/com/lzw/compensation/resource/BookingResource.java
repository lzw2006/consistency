package com.lzw.compensation.resource;

import com.lzw.common.resource.dto.CommonResp;
import com.lzw.common.resource.dto.CommonTranslator;
import com.lzw.compensation.application.BookingApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResource {

    @Autowired
    private BookingApplication bookingApplication;

    @PostMapping("/booking")
    public CommonResp booking() {
        bookingApplication.booking();
        return CommonTranslator.translateToCommonResponse();
    }

}

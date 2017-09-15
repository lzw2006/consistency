package com.lzw.flightservice.resource;

import com.lzw.common.resource.dto.CommonResp;
import com.lzw.common.resource.dto.CommonTranslator;
import com.lzw.flightservice.resource.dto.FlightBookingReq;
import com.lzw.flightservice.resource.dto.FlightCancelReq;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightResource {

    @PostMapping("/flight")
    public CommonResp bookingFlight(@RequestBody FlightBookingReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

    @DeleteMapping("/flight")
    public CommonResp cancelBookingFlight(@RequestBody FlightCancelReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

}

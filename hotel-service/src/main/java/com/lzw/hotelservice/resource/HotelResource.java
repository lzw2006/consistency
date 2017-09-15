package com.lzw.hotelservice.resource;


import com.lzw.common.resource.dto.CommonResp;
import com.lzw.common.resource.dto.CommonTranslator;
import com.lzw.hotelservice.resource.dto.HotelBookingReq;
import com.lzw.hotelservice.resource.dto.HotelCancelReq;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelResource {

    @PostMapping("/hotel")
    public CommonResp bookingFlight(@RequestBody HotelBookingReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

    @DeleteMapping("/hotel")
    public CommonResp cancelBookingFlight(@RequestBody HotelCancelReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

}

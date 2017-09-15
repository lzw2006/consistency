package com.lzw.trainservice.resource;


import com.lzw.common.resource.dto.CommonResp;
import com.lzw.common.resource.dto.CommonTranslator;
import com.lzw.trainservice.resource.dto.TrainBookingReq;
import com.lzw.trainservice.resource.dto.TrainCancelReq;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainResource {

    @PostMapping("/train")
    public CommonResp bookingFlight(@RequestBody TrainBookingReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

    @DeleteMapping("/train")
    public CommonResp cancelBookingFlight(@RequestBody TrainCancelReq req) {
        return CommonTranslator.translateToCommonResponse();
    }

}

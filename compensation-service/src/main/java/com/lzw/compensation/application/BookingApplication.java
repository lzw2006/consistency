package com.lzw.compensation.application;

import com.lzw.common.resource.dto.CommonResp;
import com.lzw.compensation.common.PlatformStatus;
import com.lzw.compensation.domain.entity.Event;
import com.lzw.compensation.domain.entity.Platform;
import com.lzw.compensation.domain.repository.EventRepository;
import com.lzw.compensation.domain.repository.PlatformRepository;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class BookingApplication {

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private EventRepository eventRepository;

    public void booking() {
        String orderId = UUID.randomUUID().toString();
        bookFlight(orderId);
        bookHotel(orderId);
        bookTrain(orderId);
    }

    private void bookFlight(String orderId) {
        sendPlatformMessage(orderId, PlatformStatus.STATUS_SENT, "flight", 1);
        RestTemplate restTemplate = new RestTemplate();
        Flight flight = new Flight();
        flight.setOrderId(orderId);
        CommonResp resp = null;
        try {
            resp = restTemplate.postForObject("http://localhost:8081/flight", flight, CommonResp.class);
        } catch (RestClientException ex) {
            updatePlatformMessage(orderId, "flight", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookFlightFail");
            return;
        } catch (Exception ex) {
            updatePlatformMessage(orderId, "flight", PlatformStatus.STATUS_UNKNOWN);
            sendEventMessage(orderId, "bookFlightFail");
            return;
        }

        if (StringUtils.equalsIgnoreCase("200", resp.getCode())) {
            updatePlatformMessage(orderId, "flight", PlatformStatus.STATUS_OK);
        } else {
            updatePlatformMessage(orderId, "flight", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookFlightFail");
        }
    }

    private void bookHotel(String orderId) {
        sendPlatformMessage(orderId, PlatformStatus.STATUS_SENT, "hotel", 2);
        RestTemplate restTemplate = new RestTemplate();
        Hotel hotel = new Hotel();
        hotel.setOrderId(orderId);
        CommonResp resp = null;
        try {
            resp = restTemplate.postForObject("http://localhost:8082/hotel", hotel, CommonResp.class);
        } catch (RestClientException ex) {
            updatePlatformMessage(orderId, "hotel", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookHotelFail");
            return;
        } catch (Exception ex) {
            updatePlatformMessage(orderId, "hotel", PlatformStatus.STATUS_UNKNOWN);
            sendEventMessage(orderId, "bookHotelFail");
            return;
        }

        if (StringUtils.equalsIgnoreCase("200", resp.getCode())) {
            updatePlatformMessage(orderId, "hotel", PlatformStatus.STATUS_OK);
        } else {
            updatePlatformMessage(orderId, "hotel", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookHotelFail");
        }
    }

    private void bookTrain(String orderId) {
        sendPlatformMessage(orderId, PlatformStatus.STATUS_SENT, "train", 3);
        RestTemplate restTemplate = new RestTemplate();
        Train train = new Train();
        train.setOrderId(orderId);
        CommonResp resp = null;
        try {
            resp = restTemplate.postForObject("http://localhost:8083/train", train, CommonResp.class);
        } catch (RestClientException ex) {
            updatePlatformMessage(orderId, "train", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookTrainFail");
            return;
        } catch (Exception ex) {
            updatePlatformMessage(orderId, "train", PlatformStatus.STATUS_UNKNOWN);
            sendEventMessage(orderId, "bookTrainFail");
            return;
        }

        if (StringUtils.equalsIgnoreCase("200", resp.getCode())) {
            updatePlatformMessage(orderId, "train", PlatformStatus.STATUS_OK);
        } else {
            updatePlatformMessage(orderId, "train", PlatformStatus.STATUS_FAIL);
            sendEventMessage(orderId, "bookTrainFail");
        }
    }

    /**
     * 发送平台消息
     *
     * @param buzId
     * @param status
     * @param service
     * @param seq
     */
    private void sendPlatformMessage(String buzId, String status, String service, Integer seq) {
        Platform p = new Platform();
        p.setBuzId(buzId);
        p.setService(service);
        p.setStatus(status);
        p.setSeq(seq);
        p.setUpdateTime(new Date());
        platformRepository.save(p);
    }

    private void updatePlatformMessage(String buzId, String service, String status) {
        Platform p = platformRepository.findByBuzIdAndService(buzId, service);
        p.setStatus(status);
        p.setUpdateTime(new Date());
        platformRepository.save(p);
    }

    /**
     * 发送事件消息
     *
     * @param buzId
     * @param event
     */
    private void sendEventMessage(String buzId, String event) {
        Event failEvent = new Event();
        failEvent.setBuzId(buzId);
        failEvent.setEvent(event);
        failEvent.setTime(new Date());
        eventRepository.save(failEvent);
    }

    @Data
    private class Flight {
        private String orderId;
    }

    @Data
    private class Hotel {
        private String orderId;
    }

    @Data
    private class Train {
        private String orderId;
    }

}

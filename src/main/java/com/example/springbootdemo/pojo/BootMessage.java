package com.example.springbootdemo.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/16 16:29
 * @Description:
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BootMessage extends BaseMessage {
    Long timeOffset = 0L;
    DeviceStatus deviceStatus = new DeviceStatus();
    PonInfo ponInfo = new PonInfo();
    PotsInfo potsInfo = new PotsInfo();

    @JsonProperty(value = "WLANNeighbor")
    WlanNeighbor WLANNeighbor = new WlanNeighbor();
    @JsonProperty(value = "subDeviceInfo")
    SubDeviceInfo subDeviceInfo = new SubDeviceInfo();
}

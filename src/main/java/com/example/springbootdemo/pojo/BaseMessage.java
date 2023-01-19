package com.example.springbootdemo.pojo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.service.CsvConvertor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/15 15:57
 * @Description:
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public abstract class BaseMessage {

    String actualTime = "";
    EventType eventType=new EventType();
    DpiVersionInfo dpiVersionInfo = new DpiVersionInfo();
    String cityCode = "";
    DeviceInfo deviceInfo=new DeviceInfo();

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class EventType {
        String eventCode = "" ;
        String subEvent = "" ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DpiVersionInfo {
        String version = "";
        String interfaceVersion = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DeviceInfo {
        String deviceId = "";
        String manufacturer = "";
        String cpu = "";
        String hardwareVersion = "";
        String firmwareVersion = "";
        String style = "";
        String model = "";
        String mac = "";
        WifiInfo wifiInfo;
        List<WifiInfo> wifiInfoList;
        String nfcSupport = "";
        String flashSize = "";
        String ram_size = "";
        String province = "";
        Map<String, Object> otherInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class WifiInfo {
        String SSID = "";
        String SSIDname = "";
        String SSIDMAC = "";
        String SSIDEnable = "";
        String SSIDAdvertisement = "";
        String SSIDStandard = "";
        String SSIDEncryptionMode = "";
        String channel = "";
        String nfcSupport = "";
        String flashSize = "";
        String ram_size = "";
        String transmitPower;
        String noiseLevel = "";
        String interferencePercent = "";
        String IdlePercent = "";
        String RecvPackets = "";
        String SendPackets = "";
        String BeaconFails = "";
        String RecvErrorPackets = "";

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DeviceStatus {
        String bootTime = "";
        String runingTime = "";
        String sampleTime = "";
        String CPU = "";
        String RAM = "";
        String lanIP = "";
        String wanIP = "";
        String lan1ConnectStatus = "";
        String lan2ConnectStatus = "";
        String lan3ConnectStatus = "";
        String lan4ConnectStatus = "";
        String WAN = "";
        String WIFI = "";
        String PPPOEError = "";
        String PPPOEStatus = "";
        String PPPOEUpTime = "";
        String lanIPV6 = "";
        String wanIPV6 = "";
        String Username = "";
        String MainChipTemperature = "";
        Map<String, Object> reportFailInfo;
        Map<String, Object> pppoeConnectInfo;
        Map<String, Object> detailsWANIfInfo;
        Map<String, Object> otherInfo;

    }



    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class PonInfo {
        String PONTXPower = "";
        String PONRXPower = "";
        Map<String, Object> otherInfo;

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class PotsInfo {
        String potsIndex = "";
        String potsPhoneNumber = "";
        String potsStatus = "";
        Map<String, Object> otherInfo;
    }


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class WlanNeighbor {
        String number = "";
        List<RadioInfo> radioInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class RadioInfo {
        String radioType = "";
        String SSIDName = "";
        String Mac = "";
        String channel = "";
        String WLANRadioPower = "";
        Map<String, Object> otherInfo;

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class SubDeviceInfo {
        String subDeviceNumber  = "";
        List<DeviceInfoOfSubDevice> deviceInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DeviceInfoOfSubDevice {
        String deviceType = "";
        String connectType = "";
        String upTime = "";
        String connectStatus = "";
        String offLineTimes = "";
        String detailOffLineTimes = "";
        String deviceName = "";
        String manufacture = "";
        String model = "";
        String Mac = "";
        String averTxRate = "";
        String averRxRate = "";
        String maxTxRate = "";
        String maxRxRate = "";
        String SSIDName = "";
        String WLANRadioPower = "";
        String WLANRadioType = "";
        String upStaticstics = "";
        String downStaticstics = "";
        String IP = "";
        String LanPort = "";
        String lanNegBitRate = "";
        String duplexMode = "";
        String wlanNegRxRate = "";
        String wlanNegTxRate = "";
        String IPv6Address = "";
        String dhcpDeviceType = "";
        Map<String, Object> otherInfo;

    }

}

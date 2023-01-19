package com.example.springbootdemo.pojo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/16 16:49
 * @Description:
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class AlarmMessage extends BaseMessage{
    DnsWarningInfo dnsWarningInfo = new DnsWarningInfo();
    TcpWarningInfo tcpWarningInfo = new TcpWarningInfo();
    HttpWarningInfo httpWarningInfo = new HttpWarningInfo();
    HttpDownloadWarningInfo httpDownloadWarningInfo = new HttpDownloadWarningInfo();
    VideoFlickerWarningInfo videoFlickerWarningInfo = new VideoFlickerWarningInfo();
    ImsAndGameWarningInfo imsAndGameWarningInfo = new ImsAndGameWarningInfo();

    CPURateWarningInfo cpuRateWarningInfo = new CPURateWarningInfo();

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public class DnsWarningInfo {
        String requestTime = "";
        String dnsDomain = "";
        String dnsParseServer = "";
        String dnsResponseDelay = "";
        String dnsParseModel = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TcpWarningInfo {
        String requestTime = "";
        String url = "";
        String destinationHost = "";
        String protocol = "";
        String connectStep = "";
        String txRate = "";
        String rxRate = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class HttpWarningInfo {
        String requestTime = "";
        String url = "";
        String destinationHost = "";
        String warningType = "";
        String txRate = "";
        String rxRate = "";
        String firstGetResponse = "";
        String returnCode = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class HttpDownloadWarningInfo {
        String requestTime = "";
        String url = "";
        String destinationHost = "";
        String txRate = "";
        String rxRate = "";
        String firstGetResponse = "";
        String httpDownloadDelay = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class VideoFlickerWarningInfo {
        String requestTime = "";
        String url = "";
        String host = "";
        String protocol = "";
        String videoURL = "";
        String finalVideoURL = "";
        String videoRate = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class ImsAndGameWarningInfo {
        String requestTime = "";
        String url = "";
        String host = "";
        String protocol = "";
        String httpResponseDelay = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class CPURateWarningInfo {
        String reason = "";
        String cpuRate = "";
        Map<String,Object> otherInfo ;
    }

}

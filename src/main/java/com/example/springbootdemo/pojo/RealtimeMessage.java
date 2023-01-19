package com.example.springbootdemo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/16 16:42
 * @Description:
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class RealtimeMessage extends BaseMessage{

    PingTestInfo pingTestInfo = new PingTestInfo();
    TracerouteTestInfo tracerouteTestInfo = new TracerouteTestInfo();
    FtpTestInfo ftpTestInfo = new FtpTestInfo();
    HttpDownloadTestInfo httpDownloadTestInfo = new HttpDownloadTestInfo();

    String taskId = "";
    HttpUploadTestInfo httpUploadTestInfo = new HttpUploadTestInfo();
    OSGIDownloadTestInfo osgiDownloadTestInfo = new OSGIDownloadTestInfo();
    OSGIUploadTestInfo osgiUploadTestInfo = new OSGIUploadTestInfo();
    TcpPingTestInfo tcpPingTestInfo = new TcpPingTestInfo();
    IntraPingTestInfo intraPingTestInfo = new IntraPingTestInfo();

    WebTestInfo webTestInfo = new WebTestInfo();

    @JsonProperty(value = "VideoDownloadTestInfo")
    VideoDownloadTestInfo videoDownloadTestInfo = new VideoDownloadTestInfo();

    @JsonProperty(value = "DialingTestErrorInfo")
    DialingTestErrorInfo DialingTestErrorInfo = new DialingTestErrorInfo();

    String taskSource = "";


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class PingTestInfo {
        String host = "";
        String averageResponseTime = "";
        String maximumResponseTime = "";
        String minimumResponseTime = "";
        String dataBlockSize = "";
        String numberOfRepetitions = "";
        String successCount = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TracerouteTestInfo {
        String host = "";
        String responseTime = "";
        String hopsNumberOfEntries = "";
        List<RouteHopInfo> routeHopsInfo = new ArrayList<RouteHopInfo>();
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class RouteHopInfo {
        String HopHost = "";
        String HopHostAddress = "";
        String HopRTTimes = "";
        String HopErrorCode = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class FtpTestInfo {
        String url = "";
        String connectTime = "";
        String speed = "";
        String successRate = "";
        String duration = "";
        String connectSuccessRate = "";
        String integrityRate = "";
        String size = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class HttpDownloadTestInfo {
        String url = "";
        String connectTime = "";
        String speed = "";
        String successRate = "";
        String size = "";
        String sizePerSconds = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class HttpUploadTestInfo {
        String url = "";
        String connectTime = "";
        String speed = "";
        String size = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class OSGIDownloadTestInfo {
        String url = "";
        String TestDownloadRate = "";
        String TotalDownloadRate = "";
        String ROMTime = "";
        String BOMTime = "";
        String EOMTime = "";
        String TestBytesReceived = "";
        String TotalBytesReceived = "";
        String TCPOpenRequestTime = "";
        String TCPOpenResponseTime = "";
        String Result = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class OSGIUploadTestInfo {
        String url = "";
        String TestUploadRate = "";
        String TotalUploadRate = "";
        String ROMTime = "";
        String BOMTime = "";
        String EOMTime = "";
        String TestBytesSent = "";
        String TotalBytesSend = "";
        String TCPOpenRequestTime = "";
        String TCPOpenResponseTime = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TcpPingTestInfo {
        String host = "";
        String result = "";
        String rtt = "";
        String lost = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class IntraPingTestInfo {
        String number = "";
        List<IntraPingInfo> intraPingInfo = new ArrayList<IntraPingInfo>();
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class IntraPingInfo {
        String host = "";
        String averageResponseTime = "";
        String maximumResponseTime = "";
        String minimumResponseTime = "";
        String dataBlockSize = "";
        String numberOfRepetitions = "";
        String successCount = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class WebTestInfo {
        String url = "";
        String connectDelay;
        String firstResponseDelay = "";
        String fistPageTime = "";
        String packetLostRate = "";
        String pingDelay = "";
        String dnsParseDelay = "";
        String dnsParseResult = "";
        String size = "";
        String localTime = "";
        Map<String,Object> otherInfo ;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class VideoDownloadTestInfo {
        String url = "";
        String firstFrameTime = "";
        String stuckTimes = "";
        String buffTime = "";
        String speed = "";
        String dnsParseDelay = "";
        Map<String,Object> otherInfo ;
    }


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DialingTestErrorInfo {
        String testName = "";
        String errorCode = "";
        String otherInfo = "";
    }


}


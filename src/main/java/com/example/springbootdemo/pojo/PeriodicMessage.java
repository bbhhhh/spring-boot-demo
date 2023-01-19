package com.example.springbootdemo.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.springbootdemo.service.CsvConvertor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/14 11:19
 * @Description:
 */


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class PeriodicMessage extends BaseMessage{

    DeviceStatus deviceStatus = new DeviceStatus();
    PonInfo ponInfo = new PonInfo();
    PotsInfo potsInfo = new PotsInfo();

    //    WebRequestInfo webRequestInfo ;
//    ImsInfo imsInfo ;
//    GameInfo gameInfo ;
//    AvInfo avInfo;
    @JsonProperty(value = "WLANNeighbor")
    WlanNeighbor WLANNeighbor = new WlanNeighbor();
    @JsonProperty(value = "subDeviceInfo")
    SubDeviceInfo subDeviceInfo = new SubDeviceInfo();
    @JsonProperty(value = "serviceData")
    Servicedata serviceData = new Servicedata();
    @JsonProperty(value = "wanTrafficData")
    WanTrafficData wanTrafficData = new WanTrafficData();
    DnsRequestInfo dnsRequestInfo = new DnsRequestInfo();

    TcpInfo tcpInfo = new TcpInfo();



    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Servicedata {
        String serviceNumber = "";
        public List<ServiceBasicInfo> serviceBasicInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class ServiceBasicInfo {
        String mac = "";
        String startTime = "";
        String runningTime = "";
        String url = "";
        String domain = "";
        String protocol = "";
        String serviceType = "";
        String averTxRate = "";
        String averRxRate = "";
        String maxTxRate = "";
        String maxRxRate = "";
        String upStaticstics = "";
        String downStaticstics = "";
        TcpConnectInfo tcpConnectInfo = new TcpConnectInfo();
        HttpConnectInfo httpConnectInfo = new HttpConnectInfo();
        DnsInfo dnsInfo = new DnsInfo();
        Map<String, Object> otherinfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class WanTrafficData {
        String wanNumber = "";
        List<WanTrafficInfo> wanTrafficInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class WanTrafficInfo {
        String wanIndex = "";
        String wanName = "";
        String averTxRate = "";
        String averRxRate = "";
        String maxTxRate = "";
        String maxRxRate = "";
        Map<String, Object> otherInfo;
        String upStaticstics = "";
        String downStaticstics = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TcpConnectInfo {
        String tcpConnectTimes = "";
        String upTcpConnectTimes = "";
        String tcpConnectSuccessTimes = "";
        String tcpConnectAvgTime = "";
        String tcpReconnectRate = "";
        String upTcpReconnectRate = "";
        String tcpConnectAvgTime1 = "";
        String tcpConnectAvgTime2 = "";
        String tcpTTLInfo = "";
        String upTcpTTLInfo = "";
        Map<String, Object> otherInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class HttpConnectInfo {
        String httpResponesDelay = "";
        String httpRequestError = "";
        String httpDownloadRate = "";
        String httpRequestTimes = "";
        String httpRequestFailTimes = "";
        String httpRequestErrorList = "";
        Map<String, Object> otherInfo;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DnsInfo {
        String dnsResponseTime = "";
        String ipAddress = "";
        Map<String, Object> otherInfo;
    }


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DnsRequestInfo {
        List<DnsInfoOfDnsRequestInfo> dnsInfoList;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class DnsInfoOfDnsRequestInfo {
        String domain = "";
        String[] ipAddress = new String[]{};
        String dnsRequestTime = "";
        String dnsResponseTime = "";
        String errorInfo = "";
        Map<String, Object> otherInfo;
        String dnsAddress = "";
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TcpInfo {
        List<TcpItem> tcpInfoList;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class TcpItem {
        String ipAddress = "";
        String tcpConnectTimes = "";
        String upTcpConnectTimes = "";
        String tcpConnectSuccessTimes = "";
        String tcpConnectAvgTime1 = "";
        String tcpConnectAvgTime2 = "";
        String tcpReconnectRate = "";
        String upTcpReconnectRate = "";
    }

}

package com.example.springbootdemo.service;

import java.util.Iterator;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.pojo.BaseMessage;
import com.example.springbootdemo.pojo.PeriodicMessage;
import com.example.springbootdemo.pojo.RealtimeMessage;
import com.example.springbootdemo.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/18 15:57
 * @Description:
 */

@Slf4j
@Service
@Qualifier("RealtimeMsgConvertor")
public class RealtimeMsgConvertor extends CsvConvertor{
    @Override
    public String convertToCsv(BaseMessage baseMessage) {
        Objects.requireNonNull(baseMessage);
        RealtimeMessage realtimeMessage = (RealtimeMessage)baseMessage;

        StringBuilder sb = new StringBuilder();
        appendCommonFields(realtimeMessage,sb);

        sb.append("1").append(CommonConfig.TempFieldSeparator); // tasknum
        sb.append(realtimeMessage.getTaskId()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getAverageResponseTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getMaximumResponseTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getMinimumResponseTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getDataBlockSize()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getNumberOfRepetitions()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getPingTestInfo().getSuccessCount()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTracerouteTestInfo().getHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTracerouteTestInfo().getResponseTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTracerouteTestInfo().getHopsNumberOfEntries()).append(CommonConfig.TempFieldSeparator);
        sb.append(JsonUtils.objectToJson(realtimeMessage.getTracerouteTestInfo().getRouteHopsInfo())).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getConnectTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getSpeed()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getSuccessRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getDuration()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getConnectSuccessRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getFtpTestInfo().getIntegrityRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpDownloadTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpDownloadTestInfo().getConnectTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpDownloadTestInfo().getSpeed()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpDownloadTestInfo().getSuccessRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getConnectDelay()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getFirstResponseDelay()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getFistPageTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getPacketLostRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getDnsParseDelay()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getDnsParseResult()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getDeviceInfo().getManufacturer()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getEventType().getEventCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getEventType().getSubEvent()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getFtpTestInfo().getSize()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpDownloadTestInfo().getSize()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getWebTestInfo().getSize()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getDpiVersionInfo().getVersion()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getHttpDownloadTestInfo().getSizePerSconds()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getHttpUploadTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpUploadTestInfo().getConnectTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpUploadTestInfo().getSpeed()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getHttpUploadTestInfo().getSize()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTestDownloadRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTotalDownloadRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getROMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getBOMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getEOMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTestBytesReceived()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTotalBytesReceived()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTCPOpenRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiDownloadTestInfo().getTCPOpenResponseTime()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getOsgiUploadTestInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTestUploadRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTotalUploadRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getROMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getBOMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getEOMTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTestBytesSent()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTotalBytesSend()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTCPOpenRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getOsgiUploadTestInfo().getTCPOpenResponseTime()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getDpiVersionInfo().getInterfaceVersion()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getDialingTestErrorInfo().getTestName()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getDialingTestErrorInfo().getErrorCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTaskSource()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getTcpPingTestInfo().getHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTcpPingTestInfo().getResult()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTcpPingTestInfo().getRtt()).append(CommonConfig.TempFieldSeparator);
        sb.append(realtimeMessage.getTcpPingTestInfo().getLost()).append(CommonConfig.TempFieldSeparator);

        sb.append(realtimeMessage.getIntraPingTestInfo().getNumber()).append(CommonConfig.TempFieldSeparator);
        if (realtimeMessage.getIntraPingTestInfo() != null && realtimeMessage.getIntraPingTestInfo().getIntraPingInfo() != null
                && realtimeMessage.getIntraPingTestInfo().getIntraPingInfo().size() > 0) {
            sb.append(realtimeMessage.getIntraPingTestInfo().getIntraPingInfo().size()).append(CommonConfig.TempFieldSeparator);
            for (Iterator<RealtimeMessage.IntraPingInfo> iter = realtimeMessage.getIntraPingTestInfo().getIntraPingInfo().iterator(); iter.hasNext(); ) {
                RealtimeMessage.IntraPingInfo intraPingInfo = iter.next();
                sb.append(intraPingInfo.getHost()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getAverageResponseTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getMaximumResponseTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getMinimumResponseTime()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getDataBlockSize()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getNumberOfRepetitions()).append(CommonConfig.TempFieldSeparator);
                sb.append(intraPingInfo.getSuccessCount());

                if (iter.hasNext()) {
                    sb.append(CommonConfig.TempFieldSeparator);
                }
            }

        }

        return doFinallyProcessing(sb);
    }
}

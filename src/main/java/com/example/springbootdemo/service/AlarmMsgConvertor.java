package com.example.springbootdemo.service;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.pojo.AlarmMessage;
import com.example.springbootdemo.pojo.BaseMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/18 15:57
 * @Description:
 */

@Slf4j
@Service
@Qualifier("AlarmMsgConvertor")
public class AlarmMsgConvertor extends CsvConvertor{
    @Override
    public String convertToCsv(BaseMessage baseMessage) {
        Objects.requireNonNull(baseMessage);
        AlarmMessage alarmMessage = (AlarmMessage)baseMessage;

        StringBuilder sb = new StringBuilder();
        appendCommonFields(alarmMessage,sb);

        if (StringUtils.isNotBlank(alarmMessage.getDnsWarningInfo().getRequestTime())){
            sb.append("1").append(CommonConfig.TempFieldSeparator);
        }else{
            sb.append("0").append(CommonConfig.TempFieldSeparator);
        }
        sb.append(alarmMessage.getDnsWarningInfo().getRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getDnsWarningInfo().getDnsDomain()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getDnsWarningInfo().getDnsParseServer()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getDnsWarningInfo().getDnsResponseDelay()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getDnsWarningInfo().getDnsParseModel()).append(CommonConfig.TempFieldSeparator);

        if (StringUtils.isNotBlank(alarmMessage.getTcpWarningInfo().getRequestTime())){
            sb.append("1").append(CommonConfig.TempFieldSeparator);
        }else{
            sb.append("0").append(CommonConfig.TempFieldSeparator);
        }
        sb.append(alarmMessage.getTcpWarningInfo().getRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getDestinationHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getProtocol()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getConnectStep()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getTxRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getTcpWarningInfo().getRxRate()).append(CommonConfig.TempFieldSeparator);

        if (StringUtils.isNotBlank(alarmMessage.getHttpWarningInfo().getRequestTime())){
            sb.append("1").append(CommonConfig.TempFieldSeparator);
        }else{
            sb.append("0").append(CommonConfig.TempFieldSeparator);
        }
        sb.append(alarmMessage.getHttpWarningInfo().getRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getDestinationHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getWarningType()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getTxRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getRxRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getFirstGetResponse()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpWarningInfo().getReturnCode()).append(CommonConfig.TempFieldSeparator);

        if (StringUtils.isNotBlank(alarmMessage.getHttpDownloadWarningInfo().getRequestTime())){
            sb.append("1").append(CommonConfig.TempFieldSeparator);
        }else{
            sb.append("0").append(CommonConfig.TempFieldSeparator);
        }
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getRequestTime()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getUrl()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getDestinationHost()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getTxRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getRxRate()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getFirstGetResponse()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getHttpDownloadWarningInfo().getHttpDownloadDelay()).append(CommonConfig.TempFieldSeparator);

        sb.append(alarmMessage.getCpuRateWarningInfo().getReason()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getCpuRateWarningInfo().getCpuRate()).append(CommonConfig.TempFieldSeparator);

        sb.append(alarmMessage.getDeviceInfo().getManufacturer()).append(CommonConfig.TempFieldSeparator);

        sb.append(alarmMessage.getEventType().getEventCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getEventType().getSubEvent()).append(CommonConfig.TempFieldSeparator);

        sb.append(alarmMessage.getActualTime()).append(CommonConfig.TempFieldSeparator);

        sb.append(alarmMessage.getDpiVersionInfo().getVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(alarmMessage.getDpiVersionInfo().getInterfaceVersion());


        return doFinallyProcessing(sb);
    }
}

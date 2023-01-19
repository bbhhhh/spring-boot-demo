package com.example.springbootdemo.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springbootdemo.config.CommonConfig;
import com.example.springbootdemo.pojo.BaseMessage;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/10 10:48
 * @Description:
 */
public abstract class CsvConvertor {
    @Autowired
    CommonConfig commonConfig;

    public abstract String convertToCsv(BaseMessage baseMessage);

    static String formatEventTime(String timeStamp) {

        return CommonConfig.EVENT_TIME_FORMATTER.format(LocalDateTime.ofEpochSecond(Long.parseLong(timeStamp) / 1000, 0, CommonConfig.LocalZoneOffset));
    }

    /**
     * @Description convert YYYY-MM-DD HH:mm:ss to YYYY-MM-DD HHmmss
     * @Author haihuab
     * @Date 2022/12/16 9:24
     * @Param srcTime
     * @Return java.lang.String
     **/
    static String formatBootAndSampleTime(String srcTime) {
        return StringUtils.remove(srcTime, ':');
    }

    void appendCommonFields(BaseMessage baseMessage, StringBuilder sb){
        Objects.requireNonNull(baseMessage);
        Objects.requireNonNull(sb);

        sb.append(formatEventTime(baseMessage.getActualTime())).append(CommonConfig.TempFieldSeparator);
        sb.append(commonConfig.getProtocolVersion()).append(CommonConfig.TempFieldSeparator);
        sb.append(baseMessage.getCityCode()).append(CommonConfig.TempFieldSeparator);
        sb.append(commonConfig.getDpiProvider()).append(CommonConfig.TempFieldSeparator);
        sb.append(baseMessage.getDeviceInfo().getDeviceId()).append(CommonConfig.TempFieldSeparator);

    }

    static String doFinallyProcessing(StringBuilder sb){
        Objects.requireNonNull(sb);
        return StringUtils.replace(
                StringUtils.replaceEach(sb.toString(),new String[]{"\n","\r\n",CommonConfig.FormalFieldSeparator},new String[]{"","","%7C"}),
                CommonConfig.TempFieldSeparator,
                CommonConfig.FormalFieldSeparator);
    }
}

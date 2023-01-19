package com.example.springbootdemo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.springbootdemo.pojo.AlarmMessage;
import com.example.springbootdemo.pojo.BootMessage;
import com.example.springbootdemo.pojo.PeriodicMessage;
import com.example.springbootdemo.pojo.RealtimeMessage;
import com.example.springbootdemo.service.CsvConvertor;
import com.example.springbootdemo.sink.AlarmMsgSink;
import com.example.springbootdemo.sink.BootMsgSink;
import com.example.springbootdemo.sink.PeriodicMsgSink;
import com.example.springbootdemo.sink.RealtimeMsgSink;
import com.example.springbootdemo.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demoJsonUtils
 * @Author : haihuab
 * @Date : 2022/12/13 17:06
 * @Description:
 */

@Slf4j
@Component
public class IprobeMsgConsumer {
    @Qualifier("PeriodicMsgConvertor")
    @Autowired
    CsvConvertor periodicMsgConvertor;

    @Qualifier("BootMsgConvertor")
    @Autowired
    CsvConvertor bootMsgConvertor;

    @Qualifier("RealtimeMsgConvertor")
    @Autowired
    CsvConvertor realtimeMsgConvertor;

    @Qualifier("AlarmMsgConvertor")
    @Autowired
    CsvConvertor alarmMsgConvertor;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic-periodic}", concurrency = "${spring.kafka.listener.concurrency}")
    public void onMessagePeriodic(ConsumerRecord<String, String> record) {
        try {
            PeriodicMessage periodicMessage = JsonUtils.jsonToObject(record.value(), PeriodicMessage.class);
            if (periodicMessage != null) {
                PeriodicMsgSink.log(periodicMsgConvertor.convertToCsv(periodicMessage));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic-boot}", concurrency = "${spring.kafka.listener.concurrency}")
    public void onMessageBoot(ConsumerRecord<String, String> record) {
        try {
            BootMessage bootMessage = JsonUtils.jsonToObject(record.value(), BootMessage.class);
            if (bootMessage != null) {
                BootMsgSink.log(bootMsgConvertor.convertToCsv(bootMessage));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic-realtime}", concurrency = "${spring.kafka.listener.concurrency}")
    public void onMessageRealtime(ConsumerRecord<String, String> record) {
        try {
            RealtimeMessage realtimeMessage = JsonUtils.jsonToObject(record.value(), RealtimeMessage.class);
            if (realtimeMessage != null) {
                RealtimeMsgSink.log(realtimeMsgConvertor.convertToCsv(realtimeMessage));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic-alarm}", concurrency = "${spring.kafka.listener.concurrency}")
    public void onMessageAlarm(ConsumerRecord<String, String> record) {
        try {
            AlarmMessage alarmMessage = JsonUtils.jsonToObject(record.value(), AlarmMessage.class);
            if (alarmMessage != null) {
                AlarmMsgSink.log(alarmMsgConvertor.convertToCsv(alarmMessage));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}

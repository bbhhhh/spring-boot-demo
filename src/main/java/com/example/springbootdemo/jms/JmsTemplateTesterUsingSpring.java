package com.example.springbootdemo.jms;

import java.util.Date;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class JmsTemplateTesterUsingSpring {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt = SpringApplication.run(JmsTemplateTesterUsingSpring.class, args);
        //PooledConnectionFactory connectionFactory = ctxt.getBean(PooledConnectionFactory.class);
        CachingConnectionFactory connectionFactory = (CachingConnectionFactory) ctxt.getBean(ConnectionFactory.class);
        //((ActiveMQConnectionFactory) connectionFactory.getTargetConnectionFactory()).setUseAsyncSend(true);
        JmsTemplate jmsTmp;
        jmsTmp = ctxt.getBean(JmsTemplate.class);
        jmsTmp.setDeliveryPersistent(false);

        for (int i = 1; i <= 1; i++) {
            //jmsTmp = new JmsTemplate(connectionFactory);
            //jmsTmp.setConnectionFactory(connectionFactory);
            jmsTmp.setPubSubDomain(false);
            //jmsTmp.setExplicitQosEnabled(false);
            jmsTmp.setTimeToLive(600000);
            JmsSender jmsSender = new JmsSender("Sender" + String.valueOf(i), jmsTmp, 1000);
            jmsSender.start();
        }
    }

}

class JmsSender extends Thread {
    JmsTemplate jmsTmp;
    int count;
    String name;

    public JmsSender(String name, JmsTemplate jmsTmpl, int count) {
        super(name);
        this.name = name;
        jmsTmp = jmsTmpl;
        this.count = count;
    }

    public void run() {
        Date t1 = new Date();
        System.out.println(name + " --- " + t1);
        for (int i = 0; i < count; i++) {

            jmsTmp.convertAndSend("apmgr_test_queue", "blah");
        }
        Date t2 = new Date();
        System.out.println(name + " --- " + t2);
        System.out.println(name + " speed = " + count * 1000.0 / ((t2.getTime() - t1.getTime())));
    }

}

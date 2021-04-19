package com.example.springbootdemo.jms;

import java.util.Date;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

//@SpringBootApplication
//@EnableJms
//@EnableAutoConfiguration
public class JmsTemplateTesterWithoutSpring {

    public static void main(String[] args) {
        //ConfigurableApplicationContext ctxt = SpringApplication.run(JmstemplateApplication.class, args);
        //PooledConnectionFactory connectionFactory = ctxt.getBean(PooledConnectionFactory.class);
        //CachingConnectionFactory connectionFactory = (CachingConnectionFactory) ctxt.getBean(ConnectionFactory.class);
        //((ActiveMQConnectionFactory) connectionFactory.getTargetConnectionFactory()).setUseAsyncSend(true);
        //JmsTemplate jmsTemplate = ctxt.getBean(JmsTemplate.class);

        ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory();
        amqConnectionFactory.setBrokerURL("tcp://135.251.218.88:61616?jms.useAsyncSend=true");
        //amqConnectionFactory.setUseAsyncSend(true);
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setTargetConnectionFactory(amqConnectionFactory);
        for (int i = 1; i <= 1; i++) {
            JmsTemplate jmsTmp = new JmsTemplate(connectionFactory);
            //jmsTmp.setConnectionFactory(connectionFactory);
            jmsTmp.setPubSubDomain(false);
            jmsTmp.setExplicitQosEnabled(false);
            jmsTmp.setTimeToLive(600000);
            JmsSenderNoneSpring jmsSender = new JmsSenderNoneSpring("Sender" + String.valueOf(i), jmsTmp, 1000);
            jmsSender.start();
        }
    }

}

class JmsSenderNoneSpring extends Thread {
    JmsTemplate jmsTmp;
    int count;
    String name;

    public JmsSenderNoneSpring(String name, JmsTemplate jmsTmpl, int count) {
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

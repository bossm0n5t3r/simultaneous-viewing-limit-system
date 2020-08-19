package com.skb.pushservice.adapter;


import com.skb.pushservice.dto.WatchInfoDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private final KafkaTemplate<String, WatchInfoDto.Request> watchInfoKafkaTemplate;

    public void sendMessage(String topic, WatchInfoDto.Request dto){
        // TODO send function result로 성공 여부는 필요없는 것인가?
        watchInfoKafkaTemplate.send(topic,dto);
        logger.info(topic + " produced.");
    }

}

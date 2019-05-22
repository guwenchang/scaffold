package com.smart.log.center.event;

import com.rabbitmq.client.Channel;
import com.smart.starter.log.ConstantsLog;
import com.smart.starter.log.OpLogParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author guwenchang
 * @date 2019-05-16 15:59
 */
@Slf4j
@Component
public class OpLogHandler {

    @RabbitListener(queues = {ConstantsLog.OP_LOG_QUEUE})
    public void listenerAutoAck(OpLogParam opLogParam, Message message, Channel channel) {
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.debug("[listenerAutoAck 监听的消息] - [{}]", opLogParam.toString());
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                log.error("[listenerAutoAck 监听的消息-处理失败] - [{}]", opLogParam.toString());
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

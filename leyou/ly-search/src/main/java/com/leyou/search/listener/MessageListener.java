package com.leyou.search.listener;

import com.leyou.search.service.GoodService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    GoodService goodService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "item.search.queue",durable = "true"),
            exchange = @Exchange(name = "item.exchanges",ignoreDeclarationExceptions = "true",
                type = ExchangeTypes.TOPIC),
            key = {"item.insert","item.update"}
    ))

    public void editEsData(Long spuId) {
        System.out.println("开始监听修改ES数据，spuId="+spuId);
        goodService.editEsData(spuId);
        System.out.println("结束监听修改ES数据，spuId"+spuId);
    }


}

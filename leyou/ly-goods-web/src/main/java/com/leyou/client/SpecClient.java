package com.leyou.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "item-server")
public interface SpecClient extends SpecClientServer {

}

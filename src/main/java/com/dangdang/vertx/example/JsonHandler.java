package com.dangdang.vertx.example;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

final public class JsonHandler implements Handler<RoutingContext>{

	@Override
	public void handle(RoutingContext event) {
		String productid = event.request().getParam("productid");
		
		HttpServerResponse response =  event.response();
		response.setChunked(true);
		response.putHeader("content-type", "application/json;charset=utf-8");
		response.write("{\"productid\": \"" + productid + "\",\"c\":1}").end();
	}

}

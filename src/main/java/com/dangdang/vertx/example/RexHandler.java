package com.dangdang.vertx.example;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

final public class RexHandler implements Handler<RoutingContext>{

	@Override
	public void handle(RoutingContext event) {
		HttpServerResponse response =  event.response();
		response.setChunked(true);
		response.putHeader("content-type", "text/html;charset=utf-8");
		response.write("foo").end();
	}

}

package com.dangdang.vertx.example;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

final public class HomeHandler implements Handler<RoutingContext>{

	@Override
	public void handle(RoutingContext event) {
		event.response().end("Hello World!");		
	}

}

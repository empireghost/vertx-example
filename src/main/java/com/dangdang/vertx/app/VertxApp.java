package com.dangdang.vertx.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.metrics.MetricsOptions;

public class VertxApp {

	private static final Logger logger = LoggerFactory.getLogger(VertxApp.class);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000000; i++) {
			logger.info("ghostghostghostghost");
			
		}
		
		VertxOptions options = new VertxOptions();
		options.setWorkerPoolSize(10);
		
		options.setEventLoopPoolSize(5);
		
		Vertx vertx = Vertx.vertx(options);
		
		vertx.deployVerticle(new MyVerticle());
		
//		Thread.sleep(5000L);
//		
//		vertx.close();
		
	}
}

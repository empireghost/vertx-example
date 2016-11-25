package com.dangdang.vertx.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

public class MyVerticle extends AbstractVerticle {

	private static final Logger logger = LoggerFactory.getLogger(MyVerticle.class);

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		logger.info("MyVerticle started!");
		NetServer server = vertx.createNetServer();
		server.connectHandler(new Handler<NetSocket>() {
			@Override
			public void handle(NetSocket netSocket) {
				System.out.println("Incoming connection!");
				netSocket.handler(new Handler<Buffer>() {
                    @Override
                    public void handle(Buffer buffer) {
                        //System.out.println("incoming data: "+buffer.length());
                        String str = buffer.getString(0,buffer.length());
                        logger.info(str);
                    }
                });
			}
		});
		server.listen(10000);
	}

	@Override
	public void stop(Future<Void> stopFuture) throws Exception {
		logger.info("MyVerticle stopped!");
	}

}

package com.dangdang.vertx.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class VertxEchoServer {
	
	private static final Logger logger = LoggerFactory.getLogger(VertxEchoServer.class);

	public static void main(String[] args) {
		
		Vertx vertx = Vertx.vertx();
		
		HttpServer server = Vertx.vertx().createHttpServer();
		Router router = Router.router(vertx);

		Route route1 = router.route(HttpMethod.GET, "/").handler(new HomeHandler());

		Route jsonRoute = router.route(HttpMethod.GET, "/:productid.json").handler(new JsonHandler());

		Route xmlRoute = router.route(HttpMethod.GET, "/:productid.xml").handler(new XmlHandler());

		Route rexRoute = router.routeWithRegex(HttpMethod.GET, "/.*foo").handler(new RexHandler());
		
		server.requestHandler(new Handler<HttpServerRequest>() {
			@Override
			public void handle(HttpServerRequest req) {
				logger.info("{}", req.remoteAddress().host());
				router.accept(req);
			}
		}).listen(8080);
		
		logger.info("server start at prot 8080");
	}
}

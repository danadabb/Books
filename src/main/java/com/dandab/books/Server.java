package com.dandab.books;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * @author Dana Dabbagh
 */
public class Server
{
	private static final String BASE_API_URI = "http://localhost:8080/api/";

	public HttpServer startServer()
	{
		final ResourceConfig rc = new ResourceConfig().packages("com.dandab.Books");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_API_URI), rc);
		server.getServerConfiguration().addHttpHandler(getHttpHandler(), "/page");
		return server;
	}


	public HttpHandler getHttpHandler()
	{
		StaticHttpHandler handler = new StaticHttpHandler("src/main/resources/webapp/");
		return handler;
	}
}
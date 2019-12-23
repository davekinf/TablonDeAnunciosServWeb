import java.io.*;
import java.net.*;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import objetos.Tablon;
public class LanzadorTablon {
	
	public static void main(String[] args)
	{
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		ResourceConfig config = new ResourceConfig(Tablon.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		System.out.println("Pulsa enter para parar el servicio");
		try 
		{
			new DataInputStream(System.in).readLine();
		} 
		catch (IOException e) 
		{ }
		System.out.println("Parando...");
		server.stop(0);
	}
}

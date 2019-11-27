package helloWorld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("helloworld")
public class HelloWorld {
	
	public HelloWorld() {}
	
	@GET
	@Path("healthcheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "A api eta em cima";
	}
	
	
	@GET
	@Produces("text/html")
	public String getHtml () {
		return "<html><body><h1>Hello World!!</h1></body></html>";
	}
	
}

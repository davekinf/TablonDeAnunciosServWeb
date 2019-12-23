package objetos;
import java.io.*;
import java.util.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Path("/TablonDeAnuncios")
public class Tablon implements Serializable, Iterable<Anuncio>
{
	
	private  static HashMap<Integer, Anuncio> tablon;
	
	public Tablon()
	{
		Tablon.tablon = new HashMap<Integer, Anuncio>();
	}
	
	@GET
	@Path("/{index}")
	@Produces("MediaType.TEXT_PLAIN")
	public  Anuncio getAnuncio(@PathParam("index")Integer i)
	{
		return Tablon.tablon.get(i);
	}
	
	@POST
	public void add(Anuncio a)
	{
		Tablon.tablon.put(Tablon.tablon.size()+1,a);
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/indices")
	public Document getNombres() throws ParserConfigurationException
	{
		 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = dbf.newDocumentBuilder();
		 Document doc = builder.newDocument();
		 Element root = doc.createElement("indices");
		 
		 for (Integer n : tablon.keySet()) 
		 {
			 Element nombre = doc.createElement("indice");
			 nombre.setTextContent(n.toString());
			 root.appendChild(nombre);
		 }
		 
		 doc.appendChild(root);
		 return doc;
	}


	
//	public int tam()
//	{
//		return tablon.size();
//	}
	public Iterator<Anuncio> iterator()
	{
		return ((Iterable<Anuncio>) tablon).iterator();
	}
}

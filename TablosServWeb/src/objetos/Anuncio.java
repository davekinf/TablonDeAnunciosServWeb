package objetos;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
@XmlRootElement
public class Anuncio implements Serializable
{
	private String nombre;
	private String titulo;
	private String mensaje;
	private String correo;
	private Date fecha;
	
	public Anuncio(String n,String t, String m,String correo)
	{
		this.nombre = n;
		this.titulo = t;
		this.mensaje = m;
		this.fecha = new Date(Calendar.getInstance().getTimeInMillis());
		this.correo = correo;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getTitulo()
	{
		return titulo;
	}
	
	public void setTitulo(String t)
	{
		this.titulo = t;
	}
	
	public String getMensaje() 
	{
		return mensaje;
	}
	
	public void setMensaje(String mensaje) 
	{
		this.mensaje = mensaje;
	}
	
	public String getCorreo() 
	{
		return correo;
	}
	
	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}
	
	public Date getFecha() 
	{
		return fecha;
	}
	
	public void mostrar()
	{
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Idioma: "+this.getTitulo());
		System.out.println("Correo: "+this.getCorreo());
		System.out.println("Fecha: "+this.getFecha());
		
		System.out.println("-------------------------------------------------");
		
	}
}

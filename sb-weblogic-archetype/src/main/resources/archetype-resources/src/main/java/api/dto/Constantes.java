#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto;

import java.io.Serializable;

public class Constantes implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String MS = "MS ";
	public static final String Authorization = "Authorization";
	public static final String Timestamp = "Timestamp";
	public static final String FECHA_PATT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	public static final String environment = "/0.1/sb/wl12/environment";
	
}

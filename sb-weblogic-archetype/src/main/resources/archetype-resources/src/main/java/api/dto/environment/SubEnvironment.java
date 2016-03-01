#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto.environment;

import java.io.Serializable;

public class SubEnvironment implements Serializable{

	private static final long serialVersionUID = 1L;

	private TypeEnvironment tenv;
	private String token;
	
	public TypeEnvironment getTenv() {
		return tenv;
	}
	public void setTenv(TypeEnvironment tenv) {
		this.tenv = tenv;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "SubEnvironment [tenv=" + tenv + ", token=" + token + "]";
	}
}

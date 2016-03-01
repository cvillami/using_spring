#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto.environment;

public enum TypeEnvironment {

	APS("APS");
	
	private String env;
	
	private TypeEnvironment(String envin){
		this.env = envin;
	}

	public String getEnv() {
		return env;
	}
}

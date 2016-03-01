#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.environment;

import ${package}.api.dto.environment.ReqEnvironment;
import ${package}.api.dto.environment.ResEnvironment;
import org.springframework.http.ResponseEntity;

/**
 * Environment
 * @author @cvillamizar
 *
 */
public interface EnvironmentMS {

	/**
	 * 
	 * @param req
	 * @return
	 */
	public ResponseEntity<ResEnvironment> environment(ReqEnvironment req, String authorization, String timestamp);
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.impl.environment;


import java.text.SimpleDateFormat;

import ${package}.api.dto.Constantes;
import ${package}.api.dto.environment.ReqEnvironment;
import ${package}.api.dto.environment.ResEnvironment;
import ${package}.api.environment.EnvironmentMS;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentMSImpl implements EnvironmentMS{
	
	/**
	 * This is XML of environment
	 * <environment>
	 *		<application>AppKey</application>
	 *		<messg>
	 *			<id>Id message</id>
	 *		</messg>
	 *		<timestamp>TimeStamp</timestamp>
	 * </environment>
	 * @param req
	 * @return
	 */
	@RequestMapping(value=Constantes.environment, 
					method=RequestMethod.POST, 
					consumes={MediaType.APPLICATION_XML_VALUE},
					produces={MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody ResponseEntity<ResEnvironment> environment(@RequestBody ReqEnvironment req,
													@RequestHeader(Constantes.Authorization) String authorization,
													@RequestHeader(Constantes.Timestamp) String timestamp) {

		java.util.Date utilDate = new java.util.Date(); 
		String frm = new SimpleDateFormat(Constantes.FECHA_PATT).format(utilDate);
		
		ResEnvironment rst = new ResEnvironment();
		rst.setApp_key("SpringBoot");
		rst.setTimestamp(frm);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(Constantes.Authorization, Constantes.MS + rst.getApp_key());
		responseHeaders.add(Constantes.Timestamp, frm);
		
		return new ResponseEntity<ResEnvironment>(rst, responseHeaders, HttpStatus.OK);
	}
}

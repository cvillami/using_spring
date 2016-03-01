#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto.environment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="message")
public class MessageRst implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String tokenss;
	private String token;
	private String status;

	public String getId() {
		return id;
	}

	@XmlElement(name="id")
	public void setId(String id) {
		this.id = id;
	}

	public String getTokenss() {
		return tokenss;
	}

	@XmlElement(name="token-session")
	public void setTokenss(String tokenss) {
		this.tokenss = tokenss;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement(name="status")
	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}
	
	@XmlElement(name="session")
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "MessageRst [id=" + id + ", tokenss=" + tokenss + ", token=" + token + ", status=" + status + "]";
	}

}

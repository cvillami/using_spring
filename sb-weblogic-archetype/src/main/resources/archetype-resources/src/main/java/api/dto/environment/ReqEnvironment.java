#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto.environment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="environment")
public class ReqEnvironment implements Serializable{

	private static final long serialVersionUID = 1L;

	private String timestamp;
	private String app_key;
	private Message messg;
	
	public String getTimestamp() {
		return timestamp;
	}
	
	@XmlElement(name="timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getApp_key() {
		return app_key;
	}
	
	@XmlElement(name="application")
	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}
	public Message getMessg() {
		return messg;
	}
	public void setMessg(Message messg) {
		this.messg = messg;
	}
	
	@Override
	public String toString() {
		return "ReqEnvironment [timestamp=" + timestamp + ", app_key=" + app_key + ", messg=" + messg + "]";
	}
	
}

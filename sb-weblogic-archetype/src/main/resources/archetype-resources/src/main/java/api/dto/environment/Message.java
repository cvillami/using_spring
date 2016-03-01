#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.dto.environment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="message")
public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	@XmlElement(name="id")
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + "]";
	}

}

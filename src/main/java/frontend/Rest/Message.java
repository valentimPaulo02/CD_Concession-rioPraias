package frontend.Rest;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Message")

public class Message {
	
	private String content;
	private String operacion;
	
	
	
	public String getOperation() {
		return operacion;
	}
	
	public String getMessageContent()
	{
		return content;
	}
	
	public void setMessageContent(String content)
	{
		this.content = content;
	}
	
	
}

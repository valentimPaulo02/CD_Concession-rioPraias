package frontend.Rest;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;


@XmlRootElement(name = "Message")

public class Message {
	
	private String content;
	private String operation;
	
	public Message(){
		
	}
	
	
	public Message(String content, String operation){
		this.content = content;
		this.operation = operation;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public String getContent()
	{
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}

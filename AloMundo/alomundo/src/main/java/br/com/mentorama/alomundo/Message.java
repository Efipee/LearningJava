package br.com.mentorama.alomundo;

public class Message {

    private Integer id;
    private String message;

    public Message(final Integer id, final String message) {
        this.id = id;
        this.message = message;
    }


    public Integer getId() {
    	return this.id;
    }
    public void setId(Integer id) {
    	this.id = id;
    }


    public String getMessage() {
    	return this.message;
    }
    public void setMessage(String message) {
    	this.message = message;
    }


    
    
}

package com.aziz.contacts;

public class Contact {
	 	private String contactName;
	    private String contactNum;

	    Contact(String name,String num){
	    	this.contactName=name;
	    	this.contactNum=num;
	    }
	    public String getContactName() {
	        return contactName;
	    }
	    public void setContactName(String contactName) {
	        this.contactName = contactName;
	    }

	    public String getContactNum() {
	        return contactNum;
	    }
	    public void setContactNum(String contactNum) {
	        this.contactNum = contactName;
	    }

}

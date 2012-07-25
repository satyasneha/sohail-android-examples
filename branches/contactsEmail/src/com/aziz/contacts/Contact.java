package com.aziz.contacts;

public class Contact {
	private String contactName;
	private String OfficeNo;
	private String MobileNo;
	private String PstnNo;

	public Contact(){
		
		contactName=null;
		OfficeNo=null;  
		MobileNo=null;    
		PstnNo=null;      
		
	}
	
	public Contact(String name,String officeNo,String mobileNo,String pstnNo){
		
		if(name!=null)
		contactName=name;
		else
			contactName=null;
			
		
		if(officeNo!=null)
			OfficeNo=officeNo;
		else
			OfficeNo=null;
		
		if(mobileNo!=null)
			MobileNo=mobileNo;
		else
			MobileNo=null;
		
		if(pstnNo!=null)
			PstnNo=pstnNo;
		else
			PstnNo=null;
		
		
	}
	public String getOfficeNo() {
		return OfficeNo;
	}

	public void setOfficeNo(String officeNo) {
		OfficeNo = officeNo;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getPstnNo() {
		return PstnNo;
	}

	public void setPstnNo(String pstnNo) {
		PstnNo = pstnNo;
	}

	Contact(String name, String num) {
		this.contactName = name;

	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

}

package sohail.aziz.parcelableservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    String UserName;
    String  Password;
	
	public User(String name,String pass){
		UserName=name;
		Password=pass;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	//parcel part
	public User(Parcel in){
		String[] data= new String[2];
		
		in.readStringArray(data);
		this.UserName= data[0];
		this.Password= data[1];
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
		dest.writeStringArray(new String[]{this.UserName,this.Password});
	}
    
	public static final Parcelable.Creator<User> CREATOR= new Parcelable.Creator<User>() {

		@Override
		public User createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new User(source);  //using parcelable constructor
		}

		@Override
		public User[] newArray(int size) {
			// TODO Auto-generated method stub
			return new User[size];
		}
	};
	

}

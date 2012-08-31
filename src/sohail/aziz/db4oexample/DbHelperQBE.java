package sohail.aziz.db4oexample;

import java.util.ArrayList;

import android.util.Log;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DbHelperQBE {

	String dbpath;
	ObjectContainer db;

	boolean OpenDb(String name) {
		if (name != null) {

			db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), name);
			return true;
		}
		return false;
	}

	void CloseDb() {
		db.close();
	}
	
	void emptyDb(){
		
		ObjectSet result= db.queryByExample(new Object());
		
		while(result.hasNext()){
		       db.delete(result.next());	
		}
		
	}

	void StoreContact(Contact con) {

		db.store(con);
		db.commit();
		Log.d("sohail", "object stored");
	}

	Contact getContactByName(String name) {

		// define
		Contact obj = new Contact();
		obj.setName(name);

		ObjectSet result = db.queryByExample(obj);

		if (result.hasNext()) {
			return (Contact) result.next();
		}

		return null;

	}

	Contact getContact(Contact con) {

		ObjectSet result = db.queryByExample(con);

		if (result.hasNext()) {
			return (Contact) result.next();
		} else
			return null;

	}

	ArrayList<Contact> getAllContacts() {

		ArrayList<Contact> list = new ArrayList<Contact>();

		Contact proto = new Contact();
		ObjectSet<Contact> result = db.queryByExample(proto);

		while (result.hasNext()) {
			list.add(result.next());
		}

		return list;

	}

	boolean updateObject(Contact ObjTo, Contact ObjFrom) {

		Contact found = null;
		ObjectSet<Contact> result = db.queryByExample(ObjTo);

		if (result.hasNext()) { // if found
			found = result.next();
			found.setAge(ObjFrom.getAge()); // shallow copy just replay to, to From.
			found.setMember(ObjFrom.isMember());
			found.setName(ObjFrom.getName());
			found.setNumber(ObjFrom.getNumber());
			db.store(found);
			db.commit();
			return true;
		}

		return false;

	}

	boolean deleteObject(Contact p) {

		Contact found = null;

		ObjectSet<Contact> result = db.queryByExample(p);

		if (result.hasNext()) {
			found = result.next();

			db.delete(found);
			return true;
		} else {
			return false;
		}

	}
}

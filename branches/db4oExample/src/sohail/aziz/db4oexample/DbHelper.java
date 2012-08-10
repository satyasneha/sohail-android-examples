package sohail.aziz.db4oexample;

import android.util.Log;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DbHelper {

	String dbpath;
	ObjectContainer db;

	boolean  OpenDb(String name) {
		if (name != null) {

			db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), name);
			return true;
		}
		return false;
	}

	void StoreObject(Pilot p) {

		db.store(p);
		db.commit();
		Log.d("sohail", "object stored");
	}

	ObjectSet<Pilot> ReadObject(Pilot p) {

		return db.queryByExample(p);
	}

	ObjectSet<Pilot> ReadAll() {

		// return db.query(Pilot.class);
		// or
		Pilot p = new Pilot(null, 0);
		return db.queryByExample(p);
	}

	void updateObject(Pilot oldp, Pilot newp) {

		ObjectSet<Pilot> result = db.queryByExample(oldp);
		Pilot found = result.next();

		found = newp;

		db.store(found);
		db.commit();

	}

	void deleteObject(Pilot p) {

		ObjectSet<Pilot> result = db.queryByExample(p);
		Pilot found = result.next();

		db.delete(found);

	}

}

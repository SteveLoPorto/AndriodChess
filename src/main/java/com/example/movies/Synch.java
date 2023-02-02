package com.example.movies;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Synch extends AppCompatActivity {

	public static void saveData(ArrayList<Game> gList) throws IOException {
		try {
			File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveState.ser");
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(outFile));
			out.writeObject(gList);
			out.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static ArrayList<Game> loadData(){
		ObjectInput in;
		ArrayList<Game> ss = new ArrayList<>();
		try {
			File inFile = new File(Environment.getExternalStorageDirectory(), "appSaveState.ser");
			in = new ObjectInputStream(new FileInputStream(inFile));
			ss= (ArrayList<Game>) in.readObject();
			in.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}
}

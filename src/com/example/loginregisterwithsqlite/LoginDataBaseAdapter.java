package com.example.loginregisterwithsqlite;

import java.util.ArrayList;
import java.util.HashMap;

import example.e_homeservices.Provider;
import example.e_homeservices.Service;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class LoginDataBaseAdapter {

static final String DATABASE_NAME = "login.db";
static final int DATABASE_VERSION = 2;
public static final int NAME_COLUMN = 6;

static final String LOGIN_CREATE = "create table "+"LOGIN"+
"( " +"ID integer primary key autoincrement,FirstName varchar,Lastname varchar(100),email varchar(100)unique not null,Address varchar(100),Username varchar(100)unique not null,Password varchar(100),Contact varchar(15)) ";

static final String PROVIDER_CREATE = "create table "+"PROVIDER"+
"( " +"ID integer primary key autoincrement,FirstName varchar," +
		"Lastname varchar(100),email varchar(100) unique not null," +
		"Address varchar(100),Username varchar(100)unique not null," +
		"Password varchar(100),Contact varchar(15),Occupation varchar(100)) ";

static final String CALLING_CREATE = "create table "+"CALLING"+
 "( " +"ID integer primary key autoincrement,Customer varchar(100),Contact varchar(100),ServiceName varchar(100),PROVIDERID int,Status varchar(20) default 'Pending') ";


public SQLiteDatabase db;
private final Context context;
private DataBaseHelper dbHelper;

public LoginDataBaseAdapter(Context _context)
{
 context = _context;
 dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

}
public LoginDataBaseAdapter open() throws Exception
{
 db = dbHelper.getWritableDatabase();
return this;
}
public void close()
{
 db.close();
}

public SQLiteDatabase getDatabaseInstance()
{
 return db;
}

public int insertEntry(String First_Name,String Last_name,String Email,String Address,String Username,String Password,String Contact)
{
 ContentValues newValues = new ContentValues();
newValues.put("FirstName",First_Name);
newValues.put("Lastname",Last_name);
newValues.put("Email",Email);
newValues.put("Address",Address);
newValues.put("Username",Username);
newValues.put("Password",Password);
newValues.put("Contact",Contact);
return (int)db.insert("LOGIN", null, newValues);
}




public int insertProvider(String First_Name,String Last_name,String Email,String Address,String Username,String Password,String Contact,String Occupation)
{
ContentValues newValues = new ContentValues();
newValues.put("FirstName",First_Name);
newValues.put("Lastname",Last_name);
newValues.put("Email",Email);
newValues.put("Address",Address);
newValues.put("Username",Username);
newValues.put("Password",Password);
newValues.put("Contact",Contact);
newValues.put("Occupation",Occupation);
return (int)db.insert("Provider", null, newValues);

}

public int insertCalling(String Customer_Name,String Contact,String Service_Name,int Provider)
{
ContentValues newValues = new ContentValues();
newValues.put("Customer",Customer_Name);
newValues.put("Contact",Contact);
newValues.put("ServiceName",Service_Name);
newValues.put("ProviderId",Provider);
return (int)db.insert("CALLING", null, newValues);
}

public String getCallingContact(String Id)
{
	   Cursor cursor=db.query("CALLING", new String[]{"Contact"}, "ID=?", new String[]{Id}, null, null, null);

	   if(cursor.moveToFirst())
	   {
	 	  
	    String contact= cursor.getString(cursor.getColumnIndex("Contact"));
	    
	    cursor.close();
	     return contact; 
	    }
	   else
	   {
	 	  cursor.close();
	 	  return "NOT EXIST";
	 	  
	   }
}

public int updateCalling(String Id)
{
	ContentValues values=new ContentValues();
	values.put("Status", "Solve");
	int a=db.update("CALLING",values, "ID=?", new String[]{Id});
	return a;
}

public int deleteEntry(String password)
{
String where="PASSWORD=?";
int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{password}) ;
return numberOFEntriesDeleted;
}

public String getSinlgeEntry(String username)
{
	
   Cursor cursor=db.query("LOGIN", new String[]{"ID","Username","Password"}, "Username=?", new String[]{username}, null, null, null);

  if(cursor.moveToFirst())
  {
	  
   String repassword= cursor.getString(cursor.getColumnIndex("Password"));
   
   cursor.close();
    return repassword; 
   }
  else
  {
	  cursor.close();
	  return "NOT EXIST";
	  
  }
}

public String getSinlgeUserContact(String username)
{
	
   Cursor cursor=db.query("LOGIN", new String[]{"Username","Contact"}, "Username=?", new String[]{username}, null, null, null);

  if(cursor.moveToFirst())
  {
   String repassword= cursor.getString(cursor.getColumnIndex("Contact"));
   cursor.close();
    return repassword; 
   }
  else
  {
	  cursor.close();
	  return "NOT EXIST";
	  
  }
}

public String getSinlgeProviderContact(String Id)
{
	
   Cursor cursor=db.query("PROVIDER", new String[]{"Username","Contact"}, "ID=?", new String[]{Id}, null, null, null);

  if(cursor.moveToFirst())
  {
   String repassword= cursor.getString(cursor.getColumnIndex("Contact"));
   cursor.close();
   return repassword; 
   }
  else
  {
	  cursor.close();
	  return "NOT EXIST";
	  
  }
}




public String getSinlgeProvider(String username)
{
	
Cursor cursor=db.query("Provider", new String[]{"ID","Username","Password"}, "Username=?", new String[]{username}, null, null, null);

  if(cursor.moveToFirst())
  {
	  String id=cursor.getString(0);
   String repassword= cursor.getString(2);
   cursor.close();
   return repassword+","+id; 
   }
  else
  {
	  cursor.close();
	  return "NOT EXIST";
	  
  }
}
ArrayList<Provider> providerList;
public ArrayList<Provider> getProviders(String Occupation)
{
	providerList=new ArrayList<Provider>();
	db=dbHelper.getReadableDatabase();
    Cursor cursor=db.query("PROVIDER", new String[]{"ID","FirstName","LastName","Contact"}, "Occupation=?", new String[]{Occupation}, null, null, null);
while(cursor.moveToNext())
{
	
	int Id=cursor.getInt(0);
	String first=cursor.getString(1);
	String last=cursor.getString(2);
	String contact=cursor.getString(3);
	Provider pp=new Provider(Id,first+"  "+last, contact);
	providerList.add(pp);
	//Toast.makeText(getApplicationContext(), "Exception "+first,Toast.LENGTH_LONG).show();
}
return providerList;
 }

ArrayList<Service> serviceList;
public ArrayList<Service> getServices(String ID)
{
	serviceList=new ArrayList<Service>();
	db=dbHelper.getReadableDatabase();
    Cursor cursor=db.query("CALLING", new String[]{"ID","Customer","Contact","ServiceName"}, "PROVIDERID=? and Status='Pending'", new String[]{ID}, null, null, null);
while(cursor.moveToNext())
{
	
	int Id=cursor.getInt(0);
	String customer=cursor.getString(1);

	String contact=cursor.getString(2);
	String service=cursor.getString(3);
	Service pp=new Service(Id,customer, contact,service);
	serviceList.add(pp);
	//Toast.makeText(getApplicationContext(), "Exception "+first,Toast.LENGTH_LONG).show();
}
return serviceList;
 }



public String getSinlgeEmail(String email)
{
	
Cursor cursor=db.query("LOGIN", new String[]{"Password","Contact","Username"}, "Email=?", new String[]{email}, null, null, null);

  if(cursor.moveToFirst())
  {
   String password= cursor.getString(0);
   String contact= cursor.getString(1);
   String first= cursor.getString(2);
   cursor.close();
    return password+","+contact+","+first; 
   }
  else
  {
	  cursor.close();
	  return "NOT EXIST";
	  
  }
}



public void updateEntry(String First_Name,String Last_name,String Email,String Address,String Username,String Password,String Contact)
{
ContentValues updatedValues = new ContentValues();
updatedValues.put("FirstName",First_Name);
updatedValues.put("Lastname",Last_name);
updatedValues.put("Email",Email);
updatedValues.put("Address",Address);
updatedValues.put("Username",Username);
updatedValues.put("Password",Password);
updatedValues.put("Contact",Contact);
String where="USERNAME = ?";
db.update("LOGIN",updatedValues, where, new String[]{Password});
}


}
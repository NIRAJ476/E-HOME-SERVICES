package example.e_homeservices;

public class Provider {
    	 private int ID;
	    private String name;
	    private String contact;
	    

	    public Provider(int ID,String name,String contact)
	    {
	        this.ID=ID;
	        this.name=name;
	        this.contact=contact;
	        

	    }


	    public int getID() {
	        return ID;
	    }



	    public String getName() {
	        return name;
	    }



	    public String getContact() {
	        return contact;
	    }



}

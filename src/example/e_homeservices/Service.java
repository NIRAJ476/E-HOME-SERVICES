package example.e_homeservices;

public class Service {
	private int ID;
    private String name;
    private String contact;
    private String service;
    
    public Service(int ID,String name,String contact,String service)
    {
        this.ID=ID;
        this.name=name;
        this.contact=contact;
        this.service=service;

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

    public String getService()
    {
	  return service;
    }
    
}

package com.example.fieldbook;

public class User {
	private String UserIDNo;
    private String Username;
    private String Password;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String OrgUnitID;
    private int SeqID;
    
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String UserIDNo, String Username, String Password, String FirstName, String MiddleName, 
				String LastName, String OrgUnitID, int SeqID){
		 super();
	     this.UserIDNo = UserIDNo;
	     this.Username = Username;
	     this.Password = Password;
	     this.FirstName = FirstName;
	     this.MiddleName = MiddleName;
	     this.LastName = LastName;
	     this.OrgUnitID = OrgUnitID;
	     this.SeqID = SeqID;
	}
			
			 
			    	//getters & setters
			    	public String getUserIDNo() {
			    		return UserIDNo;
			    	}
		
			    	public void setUserIDNo(String UserIDNo) {
			    		this.UserIDNo = UserIDNo;
			    	}
		
			    	public String getUsername() {
			    		return Username;
			        }
		
			    	public void setUsername(String Username) {
			    		this.Username = Username;
			        }
			      
			    	public String getPassword() {
			    		return Password;
			    	}
		
			    	public void setPassword(String Password) {
			    		this.Password = Password;
			    	}
			      
			    	public String getFirstName() {
			    		return FirstName;
			    	}
		
			    	public void setFirstName(String FirstName) {
			    		this.FirstName = FirstName;
			    	}	
			      
			    	public String getMiddleName() {
			    		return MiddleName;
			        }
		
			    	public void setMiddleName(String MiddleName) {
			    		this.MiddleName = MiddleName;
			    	}
			        
			    	public String getLastName(){
			    		return LastName;
			    	}
		
			    	public void setLastName(String LastName) {
			    		this.LastName = LastName;
			    	}
			      
			    	public String getOrgUnitID() {
			    		return OrgUnitID;
			    	}
		
			    	public void setOrgUnitID(String OrgUnitID) {
			    		this.OrgUnitID = OrgUnitID;
			    	}
			      
			    	public int getSeqID() {
			    		return SeqID;
			    	}
		
			    	public void setSeqID(int SeqID) {
			    		this.SeqID = SeqID;
			    	}
			 
			    	@Override
			    	public String toString() {
			    		return "User [UserIDNo = " + UserIDNo + ", Username = " + Username + ", Password = " + Password + ", FirstName = " + FirstName + 
			    					", MiddleName = " + MiddleName + ", LastName = " + LastName + ", OrgUnitID = " + OrgUnitID + ", SeqID = " + SeqID + " ]";
			    	}
			// END OF CLASS USER			
}
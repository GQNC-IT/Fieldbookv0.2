package com.example.fieldbook;
/*
 * CLASS PROPETYMETHODASSN 
 */
public class PropertyMethodAssn {
	
	private String PropertyMethodAssnID;
    private String PropertyID;
    private String MethodID;
    private String ValidationID;
	private int SeqID;
		 
		    //constructors
	public PropertyMethodAssn(){}
		 
	public PropertyMethodAssn(String PropertyMethodAssnID, String PropertyID, String MethodID, String ValidationID, int SeqID) {
		super();
		this.PropertyMethodAssnID = PropertyMethodAssnID;
        this.PropertyID = PropertyID;
        this.MethodID = MethodID;
        this.ValidationID = ValidationID;
        this.SeqID = SeqID;
    }
		 
		//getters & setters
		public String getPropertyMethodAssnID() {
			return PropertyMethodAssnID;
		}
		
		public void setPropertyMethodAssnID(String PropertyMethodAssnID) {
			this.PropertyMethodAssnID = PropertyMethodAssnID;
		}
			      
		public String getPropertyID() {
			return PropertyID;
		}
		
		public void setPropertyID(String PropertyID) {
			this.PropertyID = PropertyID;
		}
			      
		public String getMethodID() {
			return MethodID;
		}
		
		public void setMethodID(String MethodID) {
			this.MethodID = MethodID;
		}
			      
		public String getValidationID() {
			return ValidationID;
		}
		
		public void setValidationID(String ValidationID) {
			this.ValidationID = ValidationID;
		}
			      
		public int getSeqID() {
			return SeqID;
		}
		
		public void setSeqID(int SeqID) {
			this.SeqID = SeqID;
		}
			 
		@Override
		public String toString() {
			return "Data [PropertyMethodAssnID = " + PropertyMethodAssnID + ", PropertyID = " + PropertyID + ", MethodID = " + MethodID + 
							", ValidationID = " + ValidationID + ", SeqID = " + SeqID + " ]";
		}
}
		
// END OF CLASS PROPERTYMETHODASSN
package com.example.fieldbook;

/*
 * CLASS PROPERTY
 */
public class Property{
		
	private String PropertyID;
	private String PropertyDescription;
	private String Active;
	private int SeqID;
				 
	//constructors
	public Property(){}
				 
	public Property(String PropertyID, String PropertyDescription, String Active, int SeqID) {
		super();
		this.PropertyID = PropertyID;
		this.PropertyDescription = PropertyDescription;
		this.Active = Active;
		this.SeqID = SeqID;
	}
				 
		//getters & setters
		public String getPropertyID() {
			return PropertyID;
		}
				
		public void setPropertyID(String PropertyID) {
			this.PropertyID = PropertyID;
		}
					      
		public String getPropertyDescription() {
			return PropertyDescription;
		}
				
		public void setPropertyDescription(String PropertyDescription) {
			this.PropertyDescription = PropertyDescription;
		}
					      
		public String getActive() {
			return Active;
		}
				
		public void setActive(String Active) {
			this.Active = Active;
		}
					      
		public int getSeqID() {
			return SeqID;
		}
				
		public void setSeqID(int SeqID) {
			this.SeqID = SeqID;
		}
					 
		@Override
		public String toString() {
			return "Property [PropertyID = " + PropertyID + ", PropertyDescription= " + PropertyDescription + 
					", Active = " + Active + ", SeqID = " + SeqID + " ]";
		}
}
				
// END OF CLASS PROPERTY
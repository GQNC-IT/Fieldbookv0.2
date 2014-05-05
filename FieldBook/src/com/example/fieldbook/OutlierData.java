package com.example.fieldbook;

/*
 * CLASS OUTLIERDATA 
 */
public class OutlierData{
	
	private String PropertyMethodAssnID;
	private String ValidationID;
	private String Value;
	private int SeqID;
		 
	//constructors
	public OutlierData(){}
		 
	public OutlierData(String PropertyMethodAssnID, String ValidationID, String Value, int SeqID) {
		super();
		this.PropertyMethodAssnID = PropertyMethodAssnID;
		this.ValidationID = ValidationID;
		this.Value = Value;
		this.SeqID = SeqID;
	}	 
		//getters & setters
		public String getPropertyMethodAssnID() {
			return PropertyMethodAssnID;
		}
		
		public void setPropertyMethodAssnID(String PropertyMethodAssnID) {
			this.PropertyMethodAssnID = PropertyMethodAssnID;
		}
		
		public String getValidationID() {
			return ValidationID;
		}
		
		public void setValidationID(String ValidationID) {
			this.ValidationID = ValidationID;
		}
		
		public String getValue() {
			return Value;
		}
		
		public void setValue(String Value) {
			this.Value = Value;
		}
		
		public int getSeqID() {
			return SeqID;
		}
		
		public void setSeqID(int SeqID) {
			this.SeqID = SeqID;
		}
			 
		@Override
		public String toString() {
			return "OutlierData [PropertyMethodAssnID = " + PropertyMethodAssnID + ", ValidationID= " + ValidationID + 
					", Value = " + Value + ", SeqID = " + SeqID + " ]";
		}
}

// END OF CLASS OUTLIERDATA
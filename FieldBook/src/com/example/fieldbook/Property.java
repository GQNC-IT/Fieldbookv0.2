package com.example.fieldbook;

/*
 * CLASS PROPERTY
 */
public class Property{
		
	private static String PropertyID;
	private static String PropertyDescription;
	private static String Active;
	private static int SeqID;
				 
	//constructors
	public Property(){}
				 
	public Property(String PropertyID2, String PropertyDescription2, String Active2, int SeqID2) {
		super();
		PropertyID = PropertyID2;
		PropertyDescription = PropertyDescription2;
		Active = Active2;
		SeqID = SeqID2;
	}
				 
		//getters & setters
		public static String getPropertyID() {
			return PropertyID;
		}
				
		public void setPropertyID(String PropertyID2) {
			PropertyID = PropertyID2;
		}
					      
		public static String getPropertyDescription() {
			return PropertyDescription;
		}
				
		public void setPropertyDescription(String PropertyDescription2) {
			PropertyDescription = PropertyDescription2;
		}
					      
		public static String getActive() {
			return Active;
		}
				
		public void setActive(String Active2) {
			Active = Active2;
		}
					      
		public static int getSeqID() {
			return SeqID;
		}
				
		public void setSeqID(int SeqID2) {
			SeqID = SeqID2;
		}
					 
		@Override
		public String toString() {
			return "Property [PropertyID = " + PropertyID + ", PropertyDescription= " + PropertyDescription + 
					", Active = " + Active + ", SeqID = " + SeqID + " ]";
		}
}
				
// END OF CLASS PROPERTY
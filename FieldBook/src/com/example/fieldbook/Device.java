package com.example.fieldbook;
/*
 * CLASS DEVICE 
 */
public class Device{
	
	private String DeviceID;
	private String DeviceDescription;
	private String Active;
	private int SeqID;
		 
	//constructors
	public Device(){}
		 
	public Device(String DeviceID, String DeviceDescription, String Active, int SeqID) {
		super();
		this.DeviceID = DeviceID;
		this.DeviceDescription = DeviceDescription;
		this.Active = Active;
		this.SeqID = SeqID;
	}	 
		//getters & setters
		public String getDeviceID() {
			return DeviceID;
		}
		
		public void setDeviceID(String DeviceID) {
			this.DeviceID = DeviceID;
		}
		
		public String getDeviceDescription() {
			return DeviceDescription;
		}
		
		public void setDeviceDescription(String DeviceDescription) {
			this.DeviceDescription = DeviceDescription;
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
			return "Device [DeviceID = " + DeviceID + ", DeviceDescription= " + DeviceDescription + 
					", Active = " + Active + ", SeqID = " + SeqID + " ]";
		}
}

// END OF CLASS DEVICE
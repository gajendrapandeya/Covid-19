package com.codermonkeys.covid_19;

public class HospitalItems {

   private String mHospitalName;
   private String mHospitalOpenHours;
   private String mHospitalContact;

    public HospitalItems() {
    }

    public HospitalItems(String mHospitalName, String mHospitalOpenHours, String mHospitalContact) {
        this.mHospitalName = mHospitalName;
        this.mHospitalOpenHours = mHospitalOpenHours;
        this.mHospitalContact = mHospitalContact;
    }

    public String getmHospitalName() {
        return mHospitalName;
    }

    public String getmHospitalOpenHours() {
        return mHospitalOpenHours;
    }

    public String getmHospitalContact() {
        return mHospitalContact;
    }
}

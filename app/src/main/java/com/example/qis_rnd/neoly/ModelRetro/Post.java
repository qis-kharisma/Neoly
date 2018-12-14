package com.example.qis_rnd.neoly.ModelRetro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("Remarks")
    public String page;
    @SerializedName("Status")
    public String perPage;
    @SerializedName("Data")
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("PhysicianID")
        public Integer PhysicianID;
        @SerializedName("PhysicianCode")
        public String PhysicianCode;
        @SerializedName("PhysicianName")
        public String PhysicianName;
        @SerializedName("SpecialtyName")
        public String SpecialtyName;
        @SerializedName("Salutation")
        public String Salutation;
        @SerializedName("Title")
        public String Title;
        @SerializedName("FirstName")
        public String FirstName;
        @SerializedName("MiddleName")
        public String MiddleName;
        @SerializedName("LastName")
        public String LastName;
        @SerializedName("FullName")
        public String FullName;
        @SerializedName("PrefferedName")
        public String PrefferedName;
        @SerializedName("Suffix")
        public String Suffix;
        @SerializedName("Gender")
        public String Gender;
        @SerializedName("DateOfBirth")
        public String DateOfBirth;
        @SerializedName("DateOfBirthFormat1")
        public String DateOfBirthFormat1;
        @SerializedName("CityOfBirth")
        public String CityOfBirth;
        @SerializedName("MaritalStatus")
        public String MaritalStatus;
        @SerializedName("Religion")
        public String Religion;
        @SerializedName("HomeAddress")
        public String HomeAddress;
        @SerializedName("StreetName")
        public String StreetName;
        @SerializedName("HomeCity")
        public String HomeCity;
        @SerializedName("HomeZipCode")
        public String HomeZipCode;
        @SerializedName("HomePhoneNo1")
        public String HomePhoneNo1;
        @SerializedName("HomePhoneNo2")
        public String HomePhoneNo2;
        @SerializedName("MobileNo1")
        public String MobileNo1;
        @SerializedName("MobileNo2")
        public String MobileNo2;
        @SerializedName("Nationality")
        public String Nationality;
        @SerializedName("EmailAddress")
        public String EmailAddress;
        @SerializedName("EmailAddress2")
        public String EmailAddress2;

    }

}




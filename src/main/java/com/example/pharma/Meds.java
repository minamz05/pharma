package com.example.pharma;

public class Meds {
    private int reference;
    private int DCI;
    private int price;
    private String Name;
    private String date_expd;
    private String date_perm;

    private int QTE;


    public Meds(int reference, int DCI, String Name, int price,int QTE, String date_expd, String date_perm  ) {
        this.reference = reference;
        this.QTE = QTE;
        this.DCI = DCI;
        this.Name = Name;
        this.date_expd = date_expd;
        this.date_perm = date_perm;
        this.price = price;
    }

    public Meds(){
    }

    public int getMed_ID() {
        return reference;
    }

    public void setMed_ID(int med_ID) {
        this.reference = med_ID;
    }

    public int getMed_Quantity() {
        return QTE;
    }

    public void setMed_Quantity(int med_Quantity) {
        this.QTE = med_Quantity;
    }

    public String getMed_Name() {
        return Name;
    }

    public void setMed_Name(String med_Name) {
        this.Name = med_Name;
    }

    public String getMed_Date() {
        return date_expd;
    }

    public void setMed_Date(String date_expd) {
        this.date_expd = date_expd;
    }

    public String getMed_EndDate() {
        return date_perm;
    }

    public void setMed_EndDate(String date_perm) {
        this.date_perm = date_perm;
    }


    public int getMed_Price() {
        return price;
    }

    public void setMed_Price(int price) {
        this.price =price;
    }

    @Override
    public String toString() {
        return Name;
    }
}







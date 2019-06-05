package com.example.retrofit1;

public class fields {
    private String Notes;
    private String Name;
    private String test;
//因為我測試資料只放Notes,Name兩個欄位，可以自己加
    public fields(String notes, String name) {
        Notes = notes;
        Name = name;
    }

    public fields(String test) {
       this.test = test;
    }

    public String getNotes() {
        return Notes;
    }

    public String getName() {
        return Name;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public void setName(String name) {
        Name = name;
    }
}

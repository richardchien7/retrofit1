package com.example.retrofit1;

public class Infor {
    private String id;
    private fields fields;
    private String createTime;

    public Infor(String id, fields fields1, String createTime) {
        this.id = id;
        this.fields = fields1;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public String getfieldsName() {
        return fields.getName();
    }

    public String getfieldsNote(){
        return fields.getNotes();
    }

    public String getCreateTime() {
        return createTime;
    }
}

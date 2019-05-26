package com.example.retrofit1;

public class Infor {
    private Infor[] records;
    private String id = "1";
    private fields fields;
    private String createTime;

    public Infor(String id, fields fields1, String createTime) {
        this.id = id;
        this.fields = fields1;
        this.createTime = createTime;
    }

    public Infor[] getRecords() {
        return records;
    }

    public String getId(int i) {
        return records[i].id;
    }

    public String getfieldsName() {
        return fields.getName();
    }

    public String getfieldsNote(){
        return fields.getNotes();
    }

    public fields getFields() {
        return fields;
    }

    public String getCreateTime() {
        return createTime;
    }

}

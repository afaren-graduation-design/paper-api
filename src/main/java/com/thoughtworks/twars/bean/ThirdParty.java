package com.thoughtworks.twars.bean;

public class ThirdParty {
    int id;
    int thirdPartyId;
    int userId;
    String thirdType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(int thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }
}

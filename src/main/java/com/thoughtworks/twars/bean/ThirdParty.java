package com.thoughtworks.twars.bean;

public class ThirdParty {
    int thirdPartyUserId;
    int userId;
    String type;

    public int getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(int thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

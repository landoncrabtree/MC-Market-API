// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.objects;

import com.google.gson.JsonObject;
import pw.landon.mcmapi.utilities.JSONUtilities;
import pw.landon.mcmapi.wrappers.Members;

public class Member {
    public Integer id;
    public String username;
    public String gender;
    public String timezone;
    public Long joinDate;
    public Long lastActivityDate;
    public Boolean isBanned;
    public Boolean isSuspended;
    public Boolean isRestricted;
    public Boolean isDisabled;
    public Integer posts;
    public Integer resources;
    public Integer purchases;
    public Integer posRep;
    public Integer negRep;
    public Integer neutralRep;

    public Member(Integer id) throws Exception {
        this.id = id;
        this.username = Members.getUsername(id);
        this.gender = Members.getGender(id);
        this.timezone = Members.getTimezone(id);
        this.joinDate = Members.getJoinDate(id);
        this.lastActivityDate = Members.getLastActivityDate(id);
        this.isBanned = Members.getIsBanned(id);
        this.isSuspended = Members.getIsSuspended(id);
        this.isRestricted = Members.getIsRestricted(id);
        this.isDisabled = Members.getIsDisabled(id);
        this.posts = Members.getPostCount(id);
        this.resources = Members.getResourceCount(id);
        this.purchases = Members.getPurchaseCount(id);
        this.posRep = Members.getFeedbackPositive(id);
        this.negRep = Members.getFeedbackNegative(id);
        this.neutralRep = Members.getFeedbackNeutral(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataAsString() {
        return Members.getUser(this.id);
    }

    public JsonObject getDataAsJSON() {
        return JSONUtilities.convertStringToJSON(Members.getUser(this.id));
    }
}

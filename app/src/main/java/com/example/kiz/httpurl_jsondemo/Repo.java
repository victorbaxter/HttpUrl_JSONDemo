package com.example.kiz.httpurl_jsondemo;

public class Repo {
    private String mId;
    private String mNodeId;
    private String mName;
    private String mPrivate;
    private String mOwnerId;
    private String mHtmlUrl;
    private String mDescription;

    public Repo() {
    }

    public Repo(String id, String nodeId, String name, String isPrivate, String ownerId, String htmlUrl, String description) {
        mId = id;
        mNodeId = nodeId;
        mName = name;
        mPrivate = isPrivate;
        mOwnerId = ownerId;
        mHtmlUrl = htmlUrl;
        mDescription = description;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String nodeId) {
        mNodeId = nodeId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPrivate() {
        return mPrivate;
    }

    public void setPrivate(String isPrivate) {
        mPrivate = isPrivate;
    }

    public String getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(String ownerId) {
        mOwnerId = ownerId;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}

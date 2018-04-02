package com.zhongyong.smarthome.model;

import java.io.Serializable;

public class OssAuthMessage implements Serializable {
    private String accessKeyId;
    private String secretKeyId;
    private String securityToken;

    public OssAuthMessage(String accessKeyId, String secretKeyId, String securityToken) {
        this.accessKeyId = accessKeyId;
        this.secretKeyId = secretKeyId;
        this.securityToken = securityToken;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretKeyId() {
        return secretKeyId;
    }

    public void setSecretKeyId(String secretKeyId) {
        this.secretKeyId = secretKeyId;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
}

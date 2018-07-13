package com.rhain.enterprise.model;

import java.util.Date;

public abstract class DateAudit {

    private Date createAt;
    private Date updateAt;

    public DateAudit() {
        Date now  = new Date();
        this.createAt = now;
        this.updateAt = now;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}

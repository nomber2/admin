package com.soft006.model;

import java.sql.Date;

/**
 * Created by Admin on 2017/12/19.
 */
public class RP {
    private Integer id;
    private String account;
    private String kind;
    private String name;
    private Date time;

    public RP(String account, String kind, String name, Date time) {
        this.account = account;
        this.kind = kind;
        this.name = name;
        this.time = time;
    }

    public RP() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RP{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}

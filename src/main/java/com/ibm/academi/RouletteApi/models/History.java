package com.ibm.academi.RouletteApi.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history", schema = "roulette")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer amount;
    private Integer option;
    private Integer number;
    private Integer result;
    private Integer reward;
    private String message;
    private Date createdDate;
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString(){
        String result = "";
        result += "'id':'" + this.id + "',";
        result += "'amount':'" + this.amount + "',";
        result += "'option':'" + this.option + "',";
        result += "'number':'" + this.number + "',";
        result += "'result':'" + this.result + "',";
        result += "'reward':'" + this.reward + "',";
        result += "'message':'" + this.message + "',";
        result += "'date':'" + this.createdDate.toString() + "',";
        result += "'by':'" + this.createdBy + "'";
        return "{" + result + "}";
    }
}

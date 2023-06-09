package com.network.programming.amqpgateway;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "house")
public class IotData {

    @Id
    private String id;

    @DateTimeFormat
    private Date iotDate;

    private long unixTime;
    private double watValue;

    private int workLoad;
    private int plugId;
    private int houseHoldId;
    private int houseId;

    public IotData(long unixTime, double watValue, int workLoad, int plugId, int houseHoldId, int houseId) {
        this.iotDate = new Date(unixTime*1000);
        this.unixTime = unixTime;
        this.watValue = watValue;
        this.workLoad = workLoad;
        this.plugId = plugId;
        this.houseHoldId = houseHoldId;
        this.houseId = houseId;
    }

    public Date getIotDate() {
        return iotDate;
    }

    public void setIotDate(Date iotDate) {
        this.iotDate = iotDate;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public double getWatValue() {
        return watValue;
    }

    public void setWatValue(float watValue) {
        this.watValue = watValue;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(int workLoad) {
        this.workLoad = workLoad;
    }

    public int getPlugId() {
        return plugId;
    }

    public void setPlugId(int plugId) {
        this.plugId = plugId;
    }

    public int getHouseHoldId() {
        return houseHoldId;
    }

    public void setHouseHoldId(int houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }


}




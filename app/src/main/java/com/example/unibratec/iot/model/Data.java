package com.example.unibratec.iot.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mvpires on 07/07/17.
 */

public class Data implements Serializable {

    @SerializedName("myname")
    private String myName;

    @SerializedName("cputemp")
    private float cpuTemp;

    @SerializedName("cpuload")
    private float cpuLoad;

    @SerializedName("memoryusage")
    private float memoryUsage;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public float getCpuTemp() {
        return cpuTemp;
    }

    public void setCpuTemp(float cpuTemp) {
        this.cpuTemp = cpuTemp;
    }

    public float getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(float cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public float getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(float memoryUsage) {
        this.memoryUsage = memoryUsage;
    }


}

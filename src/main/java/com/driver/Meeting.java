package com.driver;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Duration getDifference(){
        return Duration.between(startTime, endTime);
    }

    public int getEndTimeINT(){
        return endTime.getHour() * 60 + endTime.getMinute() * 60 + endTime.getSecond();
    }

    public int getStartTimeINT(){
        return startTime.getHour() * 60 + startTime.getMinute() * 60 + startTime.getSecond();
    }
}

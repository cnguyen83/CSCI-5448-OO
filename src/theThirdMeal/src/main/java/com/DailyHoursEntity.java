package com;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "DailyHours", schema = "the_third_meal", catalog = "")
public class DailyHoursEntity {
    private int dailyHoursKey;
    private byte dayOfWeek;
    private Time startTime;
    private Time endTime;
    private boolean closed;

    @Id
    @Column(name = "DailyHoursKey")
    public int getDailyHoursKey() {
        return dailyHoursKey;
    }

    public void setDailyHoursKey(int dailyHoursKey) {
        this.dailyHoursKey = dailyHoursKey;
    }

    @Basic
    @Column(name = "DayOfWeek")
    public byte getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(byte dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "StartTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "EndTime")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "Closed")
    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyHoursEntity that = (DailyHoursEntity) o;

        if (dailyHoursKey != that.dailyHoursKey) return false;
        if (dayOfWeek != that.dayOfWeek) return false;
        if (closed != that.closed) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dailyHoursKey;
        result = 31 * result + (int) dayOfWeek;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (closed ? 1 : 0);
        return result;
    }
}

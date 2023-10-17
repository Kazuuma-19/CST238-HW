/*
 * Title: Time.java
 * Abstract: This program merges two array in ascending order.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 1h
 * Date: 10/09/2023
 */

package HW06.partBC;

public class Time {
    private int hours;
    private int minutes;

    public Time() {
        this(0, 0);
    }

    public Time(int hours) {
        this(hours, 0);
    }

    public Time(int hours, int minutes) {
        if (isValid(hours, minutes)) {
            this.hours = hours;
            this.minutes = minutes;
        } else {
            this.hours = 0;
            this.minutes = 0;
        }
    }

    public boolean isValid(int hours, int minutes) {
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
    }

    public String toStandard() {
        StringBuilder sb = new StringBuilder();
        // hours
        if (this.hours == 0 || this.hours == 12) {
            sb.append("12");
        } else {
            sb.append(this.hours % 12);
        }

        sb.append(":");

        // minutes
        sb.append(String.format("%02d", this.minutes));
        // AM, PM
        sb.append(this.hours < 12 ? "AM" : "PM");

        return sb.toString();
    }

    public String toMilitary() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%02d", this.hours));
        sb.append(String.format("%02d", this.minutes));

        return sb.toString();
    }

    public Time add(Time t2) {
        int totalMinutes = this.minutes + t2.minutes;
        int totalHours = this.hours + t2.hours + (totalMinutes / 60);

        totalMinutes %= 60;
        totalHours %= 24;

        return new Time(totalHours, totalMinutes);
    }

    public String toString() {
        return toMilitary();
    }
}

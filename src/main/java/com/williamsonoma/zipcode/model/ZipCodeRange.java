package com.williamsonoma.zipcode.model;


/**
* The ZipCodeRange class acts as the model
* and implements the Comparator
* Also validates the properties
* @author  Pritam Banerjee
* @version 1.0
* @since   06/05/2017 
*/


public class ZipCodeRange implements Comparable<Object> {

    private Integer min;
    private Integer max;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        result = prime * result + ((min == null) ? 0 : min.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ZipCodeRange other = (ZipCodeRange) obj;
        if (max == null) {
            if (other.max != null)
                return false;
        } else if (!max.equals(other.max))
            return false;
        if (min == null) {
            if (other.min != null)
                return false;
        } else if (!min.equals(other.min))
            return false;
        return true;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        if (max >= 10000 && max <= 99999) {
            this.max = max;
        }else{
            this.max = 10000;
        }
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {

        if (min >= 10000 && min <= 99999) {
            this.min = min;
        } else {
            this.min = 10000;
        }
    }

    @Override
    public int compareTo(Object o) {
        ZipCodeRange zipCodeRange = (ZipCodeRange) o;

        if (this.min > zipCodeRange.getMin()) {
            return 1;
        } else if (this.min < zipCodeRange.getMin()) {
            return -1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return  "[" + min + "," + max + "]";
    }

}

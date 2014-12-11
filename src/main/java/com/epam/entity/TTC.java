package com.epam.entity;

import java.util.List;

/**
 * Created by User on 29.11.14.
 */
public class TTC {
    private int sight,clip;
    private List<Range> ranges;

    public TTC() {
    }

    public TTC(int sight, int clip) {
        this.sight = sight;
        this.clip = clip;
    }

    public int getSight() {
        return sight;
    }

    public void setSight(int sight) {
        this.sight = sight;
    }

    public int getClip() {
        return clip;
    }

    public void setClip(int clip) {
        this.clip = clip;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }
}

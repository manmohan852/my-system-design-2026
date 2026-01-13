package com.manmohan.systemdesign.moviebooking.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    String theatreId;
    String name;
    public List<Screen> screens;

    public Theatre(String theatreId, String name) {
        this.theatreId = theatreId;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

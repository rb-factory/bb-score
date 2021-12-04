package com.rbfactory.bbscore.model.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbfactory.bbscore.Player;

import java.util.Objects;
import java.util.Optional;

public class Link {
    @JsonProperty("id")
    private String id;

    @JsonProperty("locations")
    private String[] locations;

    private Player owner;

    public Link() {}


    public Link(String id) {
        this.id = id;
    }


    public Optional<Player> getOwner() {
        return Optional.ofNullable(owner);
    }


    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getID() {
        return id;
    }

    public String[] getLocations() {
        return locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

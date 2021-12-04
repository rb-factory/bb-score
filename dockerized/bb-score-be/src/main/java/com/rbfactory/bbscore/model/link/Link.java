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

    private Optional<Player> owner = Optional.empty();

    public Link() {}


    public Link(String id) {
        this.id = id;
        this.owner = Optional.empty();
    }


    public Optional<Player> getOwner() {
        return owner;
    }


    public void setOwner(Player owner) {
        this.owner = Optional.of(owner);
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

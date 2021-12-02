package com.rb_factory.bb_score.model.link;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Link {
    @JsonProperty("id")
    private String id;

    @JsonProperty("locations")
    private String[] locations;

    private Optional<Player> owner = Optional.empty();

    public Link() {}

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Link(String id) {
        this.id = id;
        this.owner = Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Player> getOwner() {
        return owner;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
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

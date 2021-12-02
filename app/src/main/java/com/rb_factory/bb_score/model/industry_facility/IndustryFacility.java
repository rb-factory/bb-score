package com.rb_factory.bb_score.model.industry_facility;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rb_factory.bb_score.model.Countable;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

public class IndustryFacility implements Countable {
    @JsonProperty("type")
    private IndustryFacilityType type;
    @JsonProperty("level")
    private int level;
    @JsonProperty("basePoint")
    private int basePoint;
    @JsonProperty("linkPoint")
    private int linkPoint;
    private Optional<Player> owner;

    public IndustryFacility() {}

    @RequiresApi(api = Build.VERSION_CODES.N)
    public IndustryFacility(IndustryFacilityType type, int level, int basePoint, int linkPoint) {
        this.type = type;
        this.level = level;
        this.basePoint = basePoint;
        this.linkPoint = linkPoint;
        this.owner = Optional.empty();
    }

    public IndustryFacilityType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getID() {
        return new StringJoiner("_")
                .add(type.name())
                .add(String.valueOf(level)).toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Player> getOwner() {
        if(owner.isPresent()){
            return owner;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndustryFacility that = (IndustryFacility) o;
        return getLevel() == that.getLevel() &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLevel());
    }

    public int getBasePoint() {
        return basePoint;
    }

    public int getLinkPoint() {
        return linkPoint;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setOwner(Player owner) {
        this.owner = Optional.ofNullable(owner);
    }

    @Override
    public int getPoint() {
        return basePoint;
    }
}

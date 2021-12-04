package com.rbfactory.bbscore.model.industry_facility;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbfactory.bbscore.model.Countable;
import com.rbfactory.bbscore.PlayerColor;

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
    private Optional<PlayerColor> owner;

    public IndustryFacility() {
    }


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


    public String getID() {
        return new StringJoiner("_")
                .add(type.name())
                .add(String.valueOf(level)).toString();
    }


    public Optional<PlayerColor> getOwner() {
        if (owner.isPresent()) {
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


    public void setOwner(PlayerColor owner) {
        this.owner = Optional.ofNullable(owner);
    }

    @Override
    public int getPoint() {
        return basePoint;
    }
}

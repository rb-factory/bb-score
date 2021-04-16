package com.rb_factory.bb_score;


import com.rb_factory.bb_score.industry_facility.IndustryFacility;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IndustryFacility.class, name = "IndustryFacility")})
public interface Element {
    String getID();

}

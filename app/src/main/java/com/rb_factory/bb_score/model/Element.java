package com.rb_factory.bb_score.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rb_factory.bb_score.model.industry_facility.IndustryFacility;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = IndustryFacility.class, name = "IndustryFacility")})
public interface Element {
    String getID();

}

package com.rbfactory.bbscore.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rbfactory.bbscore.model.industry_facility.IndustryFacility;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = IndustryFacility.class, name = "IndustryFacility")})
public interface Element {
    String getID();

}

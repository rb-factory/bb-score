package com.rb_factory.bb_score.merchant_point;

import com.rb_factory.bb_score.Element;

public class MerchantPoint implements Element {
    private final String name;
    private final String linkPoint;

    public MerchantPoint(String name, String linkPoint) {
        this.name = name;
        this.linkPoint = linkPoint;
    }

    public String getName() {
        return name;
    }

    public String getLinkPoint() {
        return linkPoint;
    }

    @Override
    public String getID() {
        return name;
    }
}

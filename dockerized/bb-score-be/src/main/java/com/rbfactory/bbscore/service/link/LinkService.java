package com.rbfactory.bbscore.service.link;

import com.rbfactory.bbscore.model.link.Link;

import java.util.List;

public interface LinkService {

    List<Link> getAllLink();

    Link getLink(int id);

    void updateLink(Link link);
}

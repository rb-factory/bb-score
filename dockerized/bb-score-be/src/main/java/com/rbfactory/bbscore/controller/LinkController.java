package com.rbfactory.bbscore.controller;

import com.rbfactory.bbscore.model.link.Link;
import com.rbfactory.bbscore.service.link.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LinkController {
    public static final String ALL_LINK_ENDPOINT = "/links";
    public static final String SINGLE_LINK_ENDPOINT = "/link";

    private final LinkService linkService;

    @GetMapping(ALL_LINK_ENDPOINT)
    public List<Link> getLinks(){
        return linkService.getAllLink();
    }

    @GetMapping(SINGLE_LINK_ENDPOINT)
    public Link getLink(@RequestParam int id){
        return linkService.getLink(id);
    }

    @PostMapping(SINGLE_LINK_ENDPOINT)
    public void updateLink(@RequestParam Link link){
        linkService.updateLink(link);
    }
}

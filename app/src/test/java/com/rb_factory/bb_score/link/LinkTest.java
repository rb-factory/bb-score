package com.rb_factory.bb_score.link;

import com.rb_factory.bb_score.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class LinkTest {
    private Link li1;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        li1 = null;
    }

    @Test
    void whenLinkHasNoOwnerOptionalEmptyIsReturned() {
        li1 = new Link("1");
        Assertions.assertEquals(Optional.empty(), li1.getOwner());
    }

    @Test
    void whenLinkHasOwnerOptionalContainerIsReturned() {
        li1 = new Link("1");
        li1.setOwner(Player.ORANGE);
        Assertions.assertEquals(Player.ORANGE, li1.getOwner().get());
    }
}
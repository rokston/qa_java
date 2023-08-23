package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {

    LionAlex lionAlexTest = new LionAlex(new Feline());

    public LionAlexTest() throws Exception {
    }

    @Test
    public void testGetKittens(){
        int actualKittensCount = lionAlexTest.getKittens();
        int expectedKittensCount = 0;
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void testGetPlaceOfLiving(){
        String actualPlace = lionAlexTest.getPlaceOfLiving();
        String expectedPlace = "Нью-Йоркский зоопарк";
        assertEquals(expectedPlace, actualPlace);
    }

    @Test
    public void testGetFriends(){

        List<String>  actualFriends = lionAlexTest.getFriends();
        List<String> expectedFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        String actualFriendsStr = String.join(", ", actualFriends);
        String expectedFriendsStr = String.join(", ", expectedFriends);
        assertEquals(expectedFriendsStr, actualFriendsStr);

    }
}

package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonTest {

    @Test
    public void testConstructor() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        assertEquals(expectedNumber, testSeason.getNumber());
        assertEquals(expectedYear, testSeason.getYear());
    }

    @Test
    public void testSetNumber() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        testSeason.setNumber(2);

        assertEquals(2, testSeason.getNumber());
    }

    @Test
    public void testSetYear() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        testSeason.setYear(2001);

        assertEquals(2001, testSeason.getYear());
    }

    @Test
    public void testSetEpisodes() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        Episode test = new Episode("Test",0);
        testSeason.setEpisodes(test);

        assertEquals(1, testSeason.getEpisodes().size());
    }

    @Test
    public void testGetNumber() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        assertEquals(1, testSeason.getNumber());
    }

    @Test
    public void testGetYear() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        assertEquals(2000, testSeason.getYear());
    }

    @Test
    public void testGetEpisodes() {
        int expectedNumber = 1;
        int expectedYear = 2000;

        Season testSeason = new Season(expectedNumber,expectedYear);

        Episode test1 = new Episode("Test1",0);
        testSeason.setEpisodes(test1);
        Episode test2 = new Episode("Test2",0);
        testSeason.setEpisodes(test2);

        assertEquals(2, testSeason.getEpisodes().size());

    }

}
//
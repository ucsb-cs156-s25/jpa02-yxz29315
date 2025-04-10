package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals_sameObject() {
        assertTrue(team.equals(team));
    }

    @Test
    public void testEquals_differentClass() {
        String notATeam = "I am not a team";
        assertFalse(team.equals(notATeam));
    }

    @Test
    public void testEquals_nullObject() {
        Team nullTeam = null;
        assertFalse(team.equals(nullTeam));
    }

    @Test
    public void testEquals_sameName_sameMembers() {
        Team t1 = new Team("test-team");
        t1.addMember("Alex");
        t1.addMember("Ben");

        Team t2 = new Team("test-team");
        t2.addMember("Alex");
        t2.addMember("Ben");

        assertTrue(t1.equals(t2));
    }

    @Test
    public void testEquals_sameName_differentMembers() {
        Team t1 = new Team("test-team");
        t1.addMember("Alex");

        Team t2 = new Team("test-team");
        t2.addMember("Ben");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEquals_differentName_sameMembers() {
        Team t1 = new Team("team1");
        t1.addMember("Alex");

        Team t2 = new Team("team2");
        t2.addMember("Alex");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEqualsAndHashCode() {
        Team t1 = new Team();
        t1.setName("a");
        t1.addMember("b");

        Team t2 = new Team();
        t2.setName("a");
        t2.addMember("b");

        assertTrue(t1.equals(t2), "Teams with same content should be equal");
        assertEquals(t1.hashCode(), t2.hashCode(), "Equal teams must have equal hash codes");
    }

    @Test
    public void testSpecificHashCode() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");

        int result = t.hashCode();
        
        int expectedResult = 130294;

        assertEquals(expectedResult, result, "The hashCode value should match the expected value.");
    }
}

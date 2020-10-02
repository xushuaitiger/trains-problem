package com.tiger.commands;

import com.tiger.service.LLRailRoadService;
import com.tiger.service.LLRailRoadServiceImpl;
import com.tiger.util.LLTownMap;
import com.tiger.util.LLTownMapImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;

/**
 * Tests for {@code LLRailRoadServiceCommandFactory}.
 */
public class LLRailRoadServiceCommandFactoryTest {
    private LLRailRoadServiceCommandFactory factory;

    @Before
    public void initObjects() {
        LLTownMap map = new LLTownMapImpl();
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            // Create a LLRailRoadService
            File graphFile = new File(classLoader.getResource("graph.txt").getFile());
            map.init(graphFile.getAbsolutePath());
            LLRailRoadService service = new LLRailRoadServiceImpl(map);

            // Create an LLCommandFactory
            factory = new LLRailRoadServiceCommandFactory(service);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateShortestPathCommand() {
        LLCommand command = factory.createCommand("shortest_path;A;C");
        assertTrue(command instanceof LLShortestPathCommand);
    }

    @Test
    public void testCreateShortestPathLengthCommand() {
        LLCommand command = factory.createCommand("length_of_shortest_path;A;C");
        assertTrue(command instanceof LLShortestPathLengthCommand);
    }

    @Test
    public void testCreateDistanceCommand() {
        LLCommand command = factory.createCommand("distance;A;B;C");
        assertTrue(command instanceof LLDistanceCommand);
    }

    @Test
    public void testCreateCountRoutesWithMaxHopsCommand() {
        LLCommand command = factory.createCommand("count_routes_with_max_hops;C;C;3");
        assertTrue(command instanceof LLCountRoutesWithMaxHopsCommand);
    }

    @Test
    public void testCreateCountRoutesWithHopsCommand() {
        LLCommand command = factory.createCommand("count_routes_with_hops;A;C;4");
        assertTrue(command instanceof LLCountRoutesWithHopsCommand);
    }

    @Test
    public void testCreateCountRoutesWithMaxDistanceCommand() {
        LLCommand command = factory.createCommand("count_routes_with_max_distance;C;C;29");
        assertTrue(command instanceof LLCountRoutesWithMaxDistanceCommand);
    }

    @Test(expected = NoSuchElementException.class)
    public void testUnknownCommand1() {
        LLCommand command = factory.createCommand("cccc;C;C;29");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFormat1() {
        LLCommand command = factory.createCommand("shortest_path;C;C;29");
    }
}

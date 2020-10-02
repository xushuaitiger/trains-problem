package com.tiger;

import com.tiger.commands.LLCommandFactory;
import com.tiger.commands.LLCommandProccesor;
import com.tiger.commands.LLRailRoadServiceCommandFactory;
import com.tiger.service.LLRailRoadService;
import com.tiger.service.LLRailRoadServiceImpl;
import com.tiger.util.LLPropertyFactory;
import com.tiger.util.LLTownMap;
import com.tiger.util.LLTownMapImpl;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(LLPropertyFactory.getProperties().get("usage"));
            System.exit(1);
        } else {
            String graphFilePath = args[0];
            String commandsFilePath = args[1];

            LLTownMap map = new LLTownMapImpl();
            try {
                map.init(graphFilePath);

                LLRailRoadService service = new LLRailRoadServiceImpl(map);

                // Create an LLCommandFactory
                LLCommandFactory commandFactory = new LLRailRoadServiceCommandFactory(service);

                // Create an LLCommandProccesor that uses commandFactory
                LLCommandProccesor processor = new LLCommandProccesor(commandFactory);

                System.out.println(processor.runAll(commandsFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

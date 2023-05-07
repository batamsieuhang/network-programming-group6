package com.network.programming.amqpnode;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class AmqpNodeApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate iotData;
    public static void main(String[] args) {
        SpringApplication.run(AmqpNodeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String csvFilePath = "/home/mr8/project/network-programming-group6/AMQP-node/src/main/resources/house-0.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            int id = Integer.parseInt(nextLine[0]);
            long unixTime = Long.parseLong(nextLine[1]);
            double value = Double.parseDouble(nextLine[2]);
            int workLoad = Integer.parseInt(nextLine[3]);
            int plugId = Integer.parseInt(nextLine[4]);
            int houseHoldId = Integer.parseInt(nextLine[5]);
            int houseId = Integer.parseInt(nextLine[6]);

            String msg = String.format("{\"id\": %d, \"unixTime\": %d, \"value\": %.3f, \"workLoad\": %d, \"plugId\": %d, \"houseHoldId\": %d, \"houseId\": %d}",
                    id, unixTime, value, workLoad, plugId, houseHoldId, houseId);


            iotData.convertAndSend("IOT_data","IOT_data",msg);
            System.out.println(msg);
        }

    }



}

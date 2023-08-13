package org.example;

import org.example.adapter.client.ChallengeClientAdapter;
import org.example.adapter.outbound.RestServiceAdapter;
import org.example.exceptions.CustomException;
import org.example.port.client.ChallengeClientPort;
import org.example.port.outbound.RestServicePort;

public class Main {
    public static void main(String[] args) {
        ChallengeClientPort client = new ChallengeClientAdapter();
        RestServicePort service = new RestServiceAdapter(client);
        try{
            System.out.println(service.getHobbiesList());
        }catch (CustomException e){
            System.out.println("Some error occurred: " +e.getMessage());
        }
    }
}
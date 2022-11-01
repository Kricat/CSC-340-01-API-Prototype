package com.csc340.api.prototype;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * CSC 340 Assignment 2: API Prototype
 *
 * @author Kristin Cattell
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Jokes jokes;
        Gson gson = new Gson();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random"))
                .headers("accept", "application/json", "X-RapidAPI-Key", ".........................",
                        "X-RapidAPI-Host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
        System.out.println(getResponse.body());

        jokes = gson.fromJson(getResponse.body(), Jokes.class);

        System.out.println("\nHere's a Chuck Norris joke!");
        System.out.println("I apologize in advance if it's a little too vulgar! : ");
        System.out.println(jokes.getValue());
    }
}

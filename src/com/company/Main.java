package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        Files.lines(Paths.get("Text.txt"), StandardCharsets.UTF_8).forEach(str ->strings.add(str));
        List<String> words = strings.stream()
                .filter(string -> !string.isEmpty())
                .map(string -> string.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", " ").replaceAll("\\s+"," ").trim())
                .flatMap(string -> Arrays.stream(string.split(" ")).map(s -> s.toLowerCase()))
                .sorted()
                .collect(Collectors.toList());
        List<Pair> pairs = new ArrayList<>();
        com.company.Pair pair = null;
        for (String word : words) {
            if (pair == null || !pair.getWord().equals(word)) {
                pair = new Pair();
                pairs.add(pair);
                pair.setWord(word);
                pair.setCount(1);
            } else {
                pair.setCount(pair.getCount() + 1);
            }
        }

        Collections.sort(pairs);

        pairs.stream().forEach(pair1 -> System.out.println(pair1.getCount()+" "+ pair1.getWord()));
//        System.out.println(pairs.get(0).getWord()+ pairs.get(0).getCount());
//        System.out.println(pairs.get(1).getWord()+ pairs.get(1).getCount());
//        System.out.println(pairs.get(2).getWord()+ pairs.get(2).getCount());
//        System.out.println(pairs.get(pairs.size()-1).getWord()+ pairs.get(pairs.size()-1).getCount());
//        System.out.println(pairs.get(4).getWord()+ pairs.get(4).getCount());
    }
}

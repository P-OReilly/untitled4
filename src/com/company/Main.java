package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {

    private static List<List<String>> bfsAdjDict(Map<String, ArrayList<String>> a, String b) {
        List<List<String>> listList = new ArrayList<>();
        List<String> firstTempList = new ArrayList<>();
        firstTempList.add(b);
        int depth = 0;
        listList.add(firstTempList);
        Set<String> stringSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> tempSet = new HashSet<>();

        stringSet.add(b);
        visited.add(b);
        while (stringSet.size() > 0) {
            List<String> tempList = new ArrayList<>();
            for (String s : stringSet) {
                for (String s1 : a.get(s)) {
                    if (!visited.contains(s1)) {
                        tempList.add(s1);
                        tempSet.add(s1);
                        visited.add(s1);
                    }
                }
            }
            listList.add(tempList);
            stringSet.clear();
            stringSet.addAll(tempSet);
            tempSet.clear();
        }
        return listList;
    }


    public static void main(String[] args) throws IOException{
	// write your code here
        BufferedReader bufferedReader = new BufferedReader(new FileReader("dsa.txt"));
        String line = "";
        List<String> stringList = new ArrayList<>();
        Map<String, ArrayList<String>> adjDict = new HashMap<>();
        int depth = 0;
        String bfsVar = "coax";
        String bfsSearchVar = "stay";
        int diffCount = 0;

        while ((line = bufferedReader.readLine()) != null) {
            stringList.add(line);
        }

        for (String s : stringList) {
            adjDict.put(s, new ArrayList<>());
            for (String s1 : stringList) {
                diffCount = 0;
                for (int i = 0; i < 4; i++) {
                    if (s.charAt(i) == s1.charAt(i)) {
                        diffCount++;
                    }
                }
                if (diffCount == 3) {
                    if (adjDict.containsKey(s)) {
                        adjDict.get(s).add(s1);
                    }
                }
            }
        }
        System.out.println(stringList.size()+":::");
        System.out.println(adjDict.size() +":::");

        int size = -1;
        int deepness = -1;
        for (List<String>  l : bfsAdjDict(adjDict, bfsVar)) {
            deepness++;
            for (String s : l) {
                System.out.print(s +":");
                size++;
            }
            System.out.println();
            System.out.println(size +" : " + deepness);
        }
        for (List<String> l : bfsAdjDict(adjDict, bfsSearchVar)) {
            if (l.contains(bfsVar)) {
                System.out.println("----------->>  " + depth + "********");
            }
            depth++;
        }



        for (String s : adjDict.keySet()) {
            System.out.println(s +"--------> ");
            System.out.println();
            for (String s1 : adjDict.get(s)) {
                System.out.print(s1+":");
            }
            System.out.println();
            System.out.println();
        }


        }

        }




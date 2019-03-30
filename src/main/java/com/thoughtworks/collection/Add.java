package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder,rightBorder);
        int end = Math.max(leftBorder,rightBorder);
        int result=0;
        for(int iter=start;iter<=end;iter++){
            if(iter%2==0){
                result+=iter;
            }
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder,rightBorder);
        int end = Math.max(leftBorder,rightBorder);
        int result=0;
        for(int iter=start;iter<=end;iter++){
            if(iter%2!=0){
                result+=iter;
            }
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        final int[] result = {0};
        return arrayList.stream().reduce(0,(a,b)->(a+b*3+2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> {
            if(item % 2 != 0){
                return item*3+2;
            }
            else{
                return item;
            }
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int result=0;
        for(int item:arrayList){
            if(item%2 !=0){
                result += item*3+5;
            }
        }
        return result;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getList(arrayList,n -> n%2==0);
        int evenNumber = evenList.size();
        double median;
        if(evenNumber % 2 != 0){
            median = evenList.get((evenNumber+1)/2 - 1);
        }else{
            median = (evenList.get(evenNumber/2-1)+(evenList.get(evenNumber/2)))/2;
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList = getList(arrayList,n -> n%2==0);
        double total = evenList.stream().reduce(0,(a,b)->(a+b));
        return total/evenList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = getList(arrayList,n -> n%2==0);
        if(evenList.contains(specialElment)){
            return true;
        }else{
            return false;
        }
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = getList(arrayList,n -> n%2==0);
        List<Integer> result = new ArrayList<>();
        for (int item:evenList){
            if(!result.contains(item)){
                result.add(item);
            }
        }
        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = getList(arrayList,n -> n%2==0);
        List<Integer> oddList = getList(arrayList,n -> n%2!=0);
        List<Integer> evenListSorted = evenList.stream().sorted().collect(Collectors.toList());
        List<Integer> oddListSorted = oddList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenListSorted.addAll(oddListSorted);
        return evenListSorted;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>();
        for(int iter=0;iter<arrayList.size()-1;iter++){
            resultList.add((arrayList.get(iter)+arrayList.get(iter+1))*3);
        }
        return resultList;
    }

    public List<Integer> getList(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for(Integer n: list) {
            if(predicate.test(n)) {
                result.add(n);
            }
        }
        return result;
    }
}

package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer::max).get();
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer::min).get();
    }

    public double getAverage() {
        double total = arrayList.stream().reduce((a,b)->a+b).get();
        return total/arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> sortedList = arrayList.stream().sorted().collect(Collectors.toList());
        int listSize = sortedList.size();
        double medianNum;
        if(listSize %2 !=0){
            medianNum = sortedList.get((listSize+1)/2 -1);
        }else{
            medianNum = (sortedList.get(listSize/2-1)+sortedList.get(listSize/2))/2.0;
        }
        return medianNum;
    }

    public int getFirstEven() {
        for(int item:arrayList){
            if(item % 2 ==0){
                return item;
            }
        }
        return 0;
    }

    public int getIndexOfFirstEven() {
        int firstEven = 0;
        for(int item:arrayList){
            if(item % 2 ==0){
                firstEven = item;
                break;
            }
        }
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        List<Integer> uncommonItems = this.arrayList.stream().filter(item -> !arrayList.contains(item)).collect(Collectors.toList());
        System.out.println(uncommonItems);
        if(uncommonItems.size() !=0){
            return false;
        }else{
            return true;
        }
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int linkSize = arrayList.size();
        for(int item:arrayList){
            singleLink.addTailPointer(item);
        }
        if(linkSize%2 != 0 ){
            return Double.valueOf(singleLink.getNode((linkSize+1)/2).toString());
        }else{
            return (Double.valueOf(singleLink.getNode(linkSize/2).toString())
                    +Double.valueOf(singleLink.getNode(linkSize/2+1).toString()))/2.0;
        }
    }

    public int getLastOdd() {
        Collections.reverse(arrayList);
        for(int item:arrayList){
            if(item%2 != 0){
                return item;
            }
        }
        return 0;
    }

    public int getIndexOfLastOdd() {
        List<Integer> reversedList = new ArrayList<>();
        reversedList.addAll(arrayList);
        Collections.reverse(reversedList);
        int firstOdd = 0;
        for(int item:reversedList){
            if(item % 2 != 0){
                firstOdd = item;
                break;
            }
        }
        return arrayList.indexOf(firstOdd);
    }
}

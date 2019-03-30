package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int start = Math.min(left,right);
        int end = Math.max(left,right);
        for(int iter=start;iter<=end;iter++){
            result.add(iter);
        }
        if(left>right){
            Collections.reverse(result);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int start = Math.min(left,right);
        int end = Math.max(left,right);
        for(int iter=start;iter<=end;iter++){
            result.add(iter);
        }
        if(left>right){
            Collections.reverse(result);
        }
        return getList(result,n->n%2==0);
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();
        for(int item : array){
            result.add(item);
        }

        return getList(result,n -> n%2==0);
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
//        List<Integer> firstList = new ArrayList<>();
        List<Integer> firstList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for(int item1:firstArray){firstList.add(item1);}
        for(int item2:secondArray){secondList.add(item2);}
        List<Integer> uncommonItems = secondList.stream().filter(s->!firstList.contains(s)).collect(Collectors.toList());
        firstList.addAll(uncommonItems);
        return firstList;
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

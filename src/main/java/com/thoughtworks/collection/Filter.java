package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return (List<Integer>) array.stream().filter(item -> item%2==0).collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return (List<Integer>) array.stream().filter(item -> item%3==0).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream().filter(item -> secondList.contains(item)).collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}
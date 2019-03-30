package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();

        for(Integer[] iter1:array){
            for(int iter2:iter1){
                result.add(iter2);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> transformedArray = transformToOneDimesional();
        List<Integer> result = new ArrayList<>();
        for(int iter=0;iter<transformedArray.size();iter++){
            if(transformedArray.indexOf(transformedArray.get(iter)) == iter){
                result.add(transformedArray.get(iter));
            }
        }
        return result;
    }
}

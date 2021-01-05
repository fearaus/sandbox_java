package stream;

import java.util.Arrays;
import java.util.List;

public class StreamList {

    public static void main(String[] args) {

        List<String> test = Arrays.asList("ajil", "koberang","telemong");

        List<String> testNull = null;


        System.out.println(testNull.stream().findAny());

    }
}

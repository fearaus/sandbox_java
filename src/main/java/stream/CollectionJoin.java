package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionJoin {
    public static void main(String[] args) {

        List<String> scopes = Arrays.asList("AGREEMENT_PAY","SEND_OTP");

        String result  = scopes.stream()
                .map(s -> {
                    if (s == "AGREEMENT_PAY") {
                        return "AUTO_DEBIT";
                    }
                    return s;
                })
                .collect(Collectors.joining(" "));

        System.out.println("=>"+ result);

    }








}

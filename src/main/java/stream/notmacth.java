package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class notmacth {

    public static void main(String[] args) {

        List<String> scopeFromRetro = Arrays.asList("BASE_USER_INFO","USER_LOGIN_ID","HASH_USER_LOGIN_ID");
        //List<String> scopeFromRetro = new ArrayList<>();

        List<String> scopeForApi = Arrays.asList("SEND_OTP","BASE_USER_INFO");


        System.out.println("size"+ scopeFromRetro.size());
        System.out.println("result: " + notInScope(scopeFromRetro,scopeForApi));
    }


    private static boolean notInScope(List<String> scopeFromIntroSpec, List<String> scopeApi) {
        return scopeApi.stream().noneMatch(scopeFromIntroSpec::contains);
    }
}

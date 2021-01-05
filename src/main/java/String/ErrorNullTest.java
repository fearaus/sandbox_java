package String;

import org.apache.commons.lang3.StringUtils;

public class ErrorNullTest {

    public static void main(String[] args) {

      e e = new e(null);

        if (!StringUtils.isBlank(e.getMessage()) && e.getMessage().contains("404")) {
            System.out.println("error here");
        }
    }


    public static class e{
        private String message;

        e(String x){
            this.message =x;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}

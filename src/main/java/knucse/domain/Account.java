package knucse.domain;
import lombok.Data;
public class Account {
    @Data
    public static class Create{
        private String uid;
        private String upw;
    }

    @Data
    public static class Simple{
        private String uid;
        private String upw;
    }
}

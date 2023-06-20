package knucse.domain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Account {
    @Data @Getter @Setter
    public static class Create{
        private String uid;
        private String upw;
    }

    @Data @Getter @Setter
    public static class Simple{
        private String uid;
        private String upw;
    }
}

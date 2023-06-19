package knucse.domain;
import lombok.Data;

public class Novel {
    @Data
    public static class Create{
        private String nname;
        private String ncon;
    }
    @Data
    public static class Simple{
        private int nnum;
        private String nname;
        private String ncon;
    }
}

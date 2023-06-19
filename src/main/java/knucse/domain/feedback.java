package knucse.domain;

import lombok.Data;

public class Feedback {
    @Data
    public static class Create{
        public String fname;
        public String fcon;
    }
    @Data
    public static class Simple{
        private int fid;
        private String fname;
        private String fcon;
    }
}
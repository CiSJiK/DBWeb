package knucse.domain;

import lombok.Data;

public class ReadFeedback {
    @Data
    public static class Simple{
        private int fid;
        private String fcon;
    }
}

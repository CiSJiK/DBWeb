package knucse.domain;

import lombok.Data;

public class FeedbackList {

    @Data
    public static class Simple{
        private int fid;
        private String fname;
    }
}

package knucse.domain;

import lombok.Data;

public class NovelDoneList {
    @Data
    public static class Simple{
        private int nnum;
        private String nname;
        private boolean done;
    }
}

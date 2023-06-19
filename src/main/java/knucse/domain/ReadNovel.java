package knucse.domain;

import lombok.Data;

import java.sql.Date;

public class ReadNovel {
    @Data
    public static class Simple{
        private int nnum;
        private int cid;
        private String ctext;
        private String cdate;
        private String uid;
    }
}

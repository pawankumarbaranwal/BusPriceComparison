package com.pawan.pojo;

public class ClearTripBus {
    private String dt;

    private String am;

    private String at;

    private String score;

    private Dpi dpi;

    private Bpi bpi;

    private Cv[] cv;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Dpi getDpi() {
        return dpi;
    }

    public void setDpi(Dpi dpi) {
        this.dpi = dpi;
    }

    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }

    public Cv getCv() {
        return cv[0];
    }

    public void setCv(Cv[] cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "ClassPojo [dt = " + dt + ", am = " + am + ", at = " + at + ", score = " + score + ", dpi = " + dpi + ", bpi = " + bpi + ", cv = " + cv + "]";
    }

    public class Cv {
        private String[] f;

        private String mt;

        private String on;

        private String as;

        private String opid;

        private String tk;

        private String bts;

        public String getF() {
            return f[0];
        }

        public void setF(String[] f) {
            this.f = f;
        }

        public String getMt() {
            return mt;
        }

        public void setMt(String mt) {
            this.mt = mt;
        }

        public String getOn() {
            return on;
        }

        public void setOn(String on) {
            this.on = on;
        }

        public String getAs() {
            return as;
        }

        public void setAs(String as) {
            this.as = as;
        }

        public String getOpid() {
            return opid;
        }

        public void setOpid(String opid) {
            this.opid = opid;
        }

        public String getTk() {
            return tk;
        }

        public void setTk(String tk) {
            this.tk = tk;
        }

        public String getBts() {
            return bts;
        }

        public void setBts(String bts) {
            this.bts = bts;
        }

        @Override
        public String toString() {
            return "ClassPojo [f = " + f + ", mt = " + mt + ", on = " + on + ", as = " + as + ", opid = " + opid + ", tk = " + tk + ", bts = " + bts + "]";
        }
    }

    class Dpi {
        private String score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "ClassPojo [score = " + score + "]";
        }
    }

    class Bpi {
        private String score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "ClassPojo [score = " + score + "]";
        }
    }
}
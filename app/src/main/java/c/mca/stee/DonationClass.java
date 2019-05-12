package c.mca.stee;

class DonationClass {

    private String dname, demail, doccupation,dmoney, dcloth, dfood, dstationary;

    public DonationClass(String dname, String demail, String doccupation, String dmoney, String dcloth, String dfood, String dstationary) {
        this.dname = dname;
        this.demail = demail;
        this.doccupation = doccupation;
        this.dmoney = dmoney;
        this.dcloth = dcloth;
        this.dfood = dfood;
        this.dstationary = dstationary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDoccupation() {
        return doccupation;
    }

    public void setDoccupation(String doccupation) {
        this.doccupation = doccupation;
    }

    public String getDmoney() {
        return dmoney;
    }

    public void setDmoney(String dmoney) {
        this.dmoney = dmoney;
    }

    public String getDcloth() {
        return dcloth;
    }

    public void setDcloth(String dcloth) {
        this.dcloth = dcloth;
    }

    public String getDfood() {
        return dfood;
    }

    public void setDfood(String dfood) {
        this.dfood = dfood;
    }

    public String getDstationary() {
        return dstationary;
    }

    public void setDstationary(String dstationary) {
        this.dstationary = dstationary;
    }

    public DonationClass(){}
}
package c.mca.stee;

class VolunteerClass {

    private String volname,volemail,voladdress, voluri;

    public VolunteerClass(String volname, String volemail, String voladdress, String voluri) {
        this.volname = volname;
        this.volemail = volemail;
        this.voladdress = voladdress;
        this.voluri = voluri;
    }

    public String getVolname() {
        return volname;
    }

    public void setVolname(String volname) {
        this.volname = volname;
    }

    public String getVolemail() {
        return volemail;
    }




    public String getVoladdress() {
        return voladdress;
    }



    public String getVoluri() {
        return voluri;
    }



    public VolunteerClass(){

    }
}

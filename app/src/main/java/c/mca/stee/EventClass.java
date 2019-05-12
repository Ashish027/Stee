package c.mca.stee;

public class EventClass {
    private String eventname,eventtime,eventdate, eventdescription;

    public EventClass(String eventname, String eventtime, String eventdate, String eventdescription) {
        this.eventname = eventname;
        this.eventtime = eventtime;
        this.eventdate = eventdate;
        this.eventdescription = eventdescription;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventdescription() {
        return eventdescription;
    }

    public void setEventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }
    public EventClass(){

    }
}


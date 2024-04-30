public class Reservation {
    private String name;
    private String phone;
    private String day;
    private String time;

    // Constructor
    public Reservation(String name, String phone, String day, String time) {
        this.name = name;
        this.phone = phone;
        this.day = day;
        this.time = time;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

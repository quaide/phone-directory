import java.util.Objects;

public class Contact extends Object{

    private String first;
    private String last;
    private String phoneNumber;

    public Contact(String first, String last, String phoneNumber) {
        this.first = first;
        this.last = last;
        this.phoneNumber = phoneNumber;

    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return getPhoneNumber().equals(contact.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getLast(), getPhoneNumber());
    }
}

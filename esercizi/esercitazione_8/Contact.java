import java.lang.reflect.Field;

public class Contact implements Comparable<Contact> {
  private String name;
  private String surname;
  private String street;
  private long phoneNumber;

  public Contact(
    String name,
    String surname,
    String street,
    long phoneNumber
  ) {
    this.name = name;
    this.surname = surname;
    this.street = street;
    this.phoneNumber = phoneNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
  
  public void setStreet(String street) {
    this.street = street;
  }
  
  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getStreet() {
    return street;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return name + " " + surname + " " + street + " " + phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o == null) {
      return false;
    }

    if (o.getClass() != this.getClass()) {
      return false;
    }

    var other = (Contact) o;

    var areEqual =
        other.name.equals(this.name) &&
        other.surname.equals(this.surname);

    if (areEqual) {
      return true;
    }

    return false;
  }

  @Override
  public int compareTo(Contact other) {
    if (this.equals(other)) {
      return 0;
    }

    int nameRes = this.name.compareTo(other.name);
    if (nameRes != 0) {
      return nameRes;
    }

    int surnameRes = this.surname.compareTo(other.surname);
    if (surnameRes != 0) {
      return surnameRes;
    }

    int streetRes = this.street.compareTo(other.street);
    if (streetRes != 0) {
      return streetRes;
    }

    long phoneNumberRes = this.phoneNumber - other.phoneNumber;
    if (phoneNumberRes < 0) {
      return -1;
    }
    else if (phoneNumberRes > 0) {
      return +1;
    }

    return 0;
  }
}

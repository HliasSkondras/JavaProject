package SOED.Users;

public abstract class User {

    //region Private variables.

    private String name, phone;

    //endregion

    //region Constructors.

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //endregion

    //region Public methods.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    //endregion
}

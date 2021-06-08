package SOED.Users;

public class Admin extends User {

    //region Private variables.

    private boolean isAdmin = true;

    //endregion

    //region Constructors.

    public Admin(String name, String phone, boolean isAdmin) {
        super(name, phone);
        if (!isAdmin)
            this.isAdmin = true;
    }

    //endregion

    //region Public methods.

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "isAdmin=" + isAdmin +
                '}';
    }

    //endregion
}

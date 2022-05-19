package model.Account;

public class Account {

    private String ID_NVQL;
    private String Password;

    public Account(String ID_NVQL, String Password) {
        this.ID_NVQL = ID_NVQL;
        this.Password = Password;
    }

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void show() {
        System.err.println(this.ID_NVQL + " " + this.Password);
    }

    public boolean check(String a, String b) {
        if (this.ID_NVQL.compareTo(a) == 0 && this.Password.compareTo(b) == 0) {
            return true;
        }
        return false;
    }
}

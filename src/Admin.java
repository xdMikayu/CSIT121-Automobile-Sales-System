package projectfinal;

import java.util.ArrayList;

class Admin extends User {
    private int adminID;
    private String role;
    private String department;
    private ArrayList<String> permissions;

    public Admin(String name, String username, String password, String email, int adminID, String role, String department) {
        super(name, username, password, email);
        this.adminID = adminID;
        this.role = role;
        this.department = department;
        this.permissions = new ArrayList<>();
    }

    public int getAdminID() {
        return adminID;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void addPermission(String permission) {
        permissions.add(permission);
    }

    public void removePermission(String permission) {
        permissions.remove(permission);
    }
}



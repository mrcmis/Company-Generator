package employees;


public abstract class AbstractEmployee implements Employee {

    private final Role role;
    private final Sex sex;
    private final String name;
    private final String surname;
    private final String university;
    private final String email;
    private final String country;


    public AbstractEmployee(String name, String surname, Role role, Sex sex, String university, String email, String country) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.sex = sex;
        this.university = university;
        this.email = email;
        this.country = country;
    }

    public AbstractEmployee(EmployeeBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.role = builder.role;
        this.sex = builder.sex;
        this.university = builder.university;
        this.email = builder.email;
        this.country = builder.country;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return getRole() + " name: " + getName() + " surname: " + getSurname()
                + " Role: " + getRole() + " Sex: " + getSex() + " university: "
                + getUniversity() + " email: " + getEmail() + " country: " + getCountry();
    }

    public static class EmployeeBuilder<T extends EmployeeBuilder> {

        private String name;
        private String surname;
        private Role role;
        private Sex sex;
        private String university;
        private String email;
        private String country;

        public T setName(String name) {
            this.name = name;
            return (T) this;
        }

        public T setSurname(String surname) {
            this.surname = surname;
            return (T) this;
        }

        public T setRole(Role role) {
            this.role = role;
            return (T) this;
        }

        public T setSex(Sex sex) {
            this.sex = sex;
            return (T) this;
        }

        public T setUniversity(String university) {
            this.university = university;
            return (T) this;
        }

        public T setEmail(String email) {
            this.email = email;
            return (T) this;
        }

        public T setCountry(String country) {
            this.country = country;
            return (T) this;
        }

    }
}

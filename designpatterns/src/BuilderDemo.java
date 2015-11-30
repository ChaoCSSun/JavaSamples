/**
 * 构造者模式
 * 当一个对象的构造参数很多时，可以使用
 * http://www.programcreek.com/2013/02/java-design-pattern-builder/
 * https://jlordiales.wordpress.com/2012/12/13/the-builder-pattern-in-practice/
 * Created by Tikitoo on 2015/11/30.
 */
public class BuilderDemo {
    public static void main(String[] args) {
        getUser();
    }

    public static User getUser() {
        return new User.UserBuilder()
                .firstName("Tikitoo")
                .lastName("Liang")
                .age(22)
                .phone("xxx-xxxxxx")
                .address("beijing")
                .build();
    }
}

class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address= builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}


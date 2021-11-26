package com.strategyCodingMethod;

public class User implements Compareable{
    private String username;
    private Integer age;
    private Double height;

    public User() {
    }

    public User(String username, Integer age, Double height) {
        this.username = username;
        this.age = age;
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public Integer compare(Compareable object) {
        if(object instanceof User){
            User user = (User) object;
            return this.getAge() - user.getAge();
        }
        return null;
    }
}

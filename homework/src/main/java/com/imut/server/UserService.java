package com.imut.server;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/23 16:04
 */
public class UserService {
    public String name;
    private String gender;

    private UserService() {
        System.out.println("私有构造");
    }
    public UserService(String name, String gender) {
        System.out.println("公有构造");
        this.name = name;
        this.gender = gender;
    }

    public void  getData(String name){
        System.out.println("共有方法！"+"参数："+ name);
    }

    private void  getData2(String name){
        System.out.println("私有方法！"+"参数："+ name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

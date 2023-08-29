/**
 * @author BOOM
 * @create 2023-07-28 19:37
 */
package com.hhl.test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 @author boom
 @create 2023-07-28 19:37
 */
public class HashMapTest {
    public static void main(String[] args) {
        User user = new User();
        Map<User, Integer> map = new HashMap<>(0);
        map.put(user, 1);
        System.out.println(map.get(user));
        user.setName("haha");
        System.out.println(map.get(user));
    }
}

class User {
    String name = "lili";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

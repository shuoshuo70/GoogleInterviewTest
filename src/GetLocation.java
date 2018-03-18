/**
 * Created by shuoshu on 2018/3/18.
 */
public class GetLocation {
    public int getLocation(String s, int speed) {
        int initSpeed = speed, loc = 0;
        boolean direction = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                loc += (direction ? speed : -speed);
                speed <<= 1;
            } else {
                direction = !direction;
                speed = initSpeed;
            }
        }

        return loc;
    }

}

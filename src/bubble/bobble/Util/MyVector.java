package bubble.bobble.Util;

import javax.vecmath.Vector2f;

/**
 * Created by daniel on 5/6/2017.
 */
public class MyVector {
    public static Vector2f V(float x, float y) {
        return new Vector2f(x,y);
    }

    public static Vector2f addVec(Vector2f a, Vector2f b) {
        Vector2f c = (Vector2f) a.clone();
        c.add(b);
        return c;
    }

    public static Vector2f subVec(Vector2f a, Vector2f b) {
        Vector2f c = (Vector2f) a.clone();
        c.sub(b);
        return c;
    }

    public static Vector2f scaleVec(float scalar, Vector2f vec) {
        Vector2f v = (Vector2f) vec.clone();
        v.scale(scalar);
        return v;
    }

    public static Vector2f scaleVec(Vector2f vec, float scalar) {
        Vector2f v = (Vector2f) vec.clone();
        v.scale(scalar);
        return v;
    }

    public static Vector2f cloneVec(Vector2f vec) {
        return (Vector2f) vec.clone();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author jordan
 */
public class MovableObject extends Animation {

    private Rectangle rect;
    private float speed = 0f;
    private boolean moving = false;
    private Direction direction = Direction.Right;

    public MovableObject(Rectangle rect, float speed, SpriteSheet ss, int duration) {
        super(ss, duration);
        this.rect = rect;
        this.speed = speed;
    }

    public void Update() {
        if (direction == Direction.Right) {
            rect.setX(rect.getX() + speed);
        } else if (direction == Direction.Left) {
            rect.setX(rect.getX() - speed);
        }
    }

    public void SetSpeed(float newSpeed) {
        speed = newSpeed;
    }

    public float GetSpeed() {
        return speed;
    }

    public void SetX(float x) {
        rect.setX(x);
    }

    public float GetX() {
        return rect.getX();
    }

    public void SetY(float y) {
        rect.setY(y);
    }

    public float GetY() {
        return rect.getY();
    }

    public void SetDirection(Direction newDirection) {
        direction = newDirection;
    }

    public Direction GetDirection() {
        return direction;
    }
    
    public void SetMoving(boolean moving){
        this.moving = moving;
    }
    
    public boolean GetMoving(){
        return moving;
    }
    
    public void SetRectangle(Rectangle rect){
        this.rect = rect;
    }
    
    public Rectangle GetRectangle(){
        return rect;
    }
}

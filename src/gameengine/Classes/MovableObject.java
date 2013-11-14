/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine.Classes;

import gameengine.Enums.Direction;
import java.util.HashSet;
import java.util.Set;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
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
    private boolean jumping = false;
    private boolean jumpBlocked = false;
    private int jumpCount = 0;
    private Direction direction = Direction.Right;
    private int jumpHeight = 20;
    private float jumpSpeed = 6;
    private int jumpPeak = 10;
    private int currentJumpPeak = 0;
    private int currentFrame = 0;
    private int maxFrame = 4;
    private int frameWidth = 32;

    public MovableObject(Rectangle rect, float speed, SpriteSheet ss, int duration) {
        super(ss, duration);
        this.rect = rect;
        this.speed = speed;
        //this.jumpSpeed = this.speed;
        super.setCurrentFrame(0);
        super.setAutoUpdate(false);
    }

    public void Update() {
        if (direction == Direction.Right && moving) {
            rect.setX(rect.getX() + speed);

            if (currentFrame < maxFrame) {
                currentFrame++;
                super.setCurrentFrame(currentFrame);
            } else {
                currentFrame = 0;
            }
        } else if (direction == Direction.Left && moving) {
            rect.setX(rect.getX() - speed);
        }

        if (jumping && jumpCount < jumpHeight) {
            rect.setY(rect.getY() - jumpSpeed);
            //this.speed = this.jumpSpeed;
            jumpCount++;
            jumpBlocked = true;
        } else if (currentJumpPeak < jumpPeak && jumping) {
            currentJumpPeak++;
        } else {
            jumping = false;

            //Replace with actual collision detection.
            if (jumpCount != 0) {
                rect.setY(rect.getY() + jumpSpeed);
                jumpCount--;
                currentJumpPeak = 0;
            } else {
                jumpBlocked = false;
            }
        }
        
        if(!moving){
            currentFrame = 0;
            super.setCurrentFrame(currentFrame);
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

    public void SetMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean GetMoving() {
        return moving;
    }

    public void SetRectangle(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle GetRectangle() {
        return rect;
    }

    public void Jump() {
        if (!jumpBlocked) {
            jumping = true;
        }
    }

    public void CancelJump() {
        jumping = false;
    }
}

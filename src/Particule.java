import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Particule {
    private double x, y;
    private double vx, vy;
    private double radius;
    private Color color;
    public boolean arrived = false;
    public boolean blocked = false;
    public boolean atStart = true;

    public Particule(double x, double y, double vx, double vy, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.color = color;
    }

    public void update() {
        x += vx;
        y += vy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isArrived(CustomLine endLine){
        if(endLine.getEndX() - 2 <= this.x && this.x <= endLine.getEndX() + 2){
            this.arrived = true;
            this.setX(endLine.getEndX());
            this.setVx(0);
        }
        return this.arrived;
    }

    @Override
    public String toString() {
        return "Particule [x=" + x + ", y=" + y + ", vx=" + vx + ", arrived=" + arrived + ", blocked=" + blocked + ", atStart="
                + atStart + "]";
    }

    public boolean isBlocked(ArrayList<CustomLine> walls){
        for(CustomLine wall : walls){
            if(wall.getStartX() - 2 <= this.x && this.x <= wall.getStartX() + 2){
                if(wall.getStartY() <= this.y && this.y <= wall.getEndY()){
                    this.setX(wall.getStartX());
                    this.setVx(0);
                    this.blocked = true;
                }
            }
        }
        return this.blocked;
    }
}

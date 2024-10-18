package org.simplemedium;

/**
 * 18. Problem Statement:
 *
 * A robot moves on a grid. The grid has a X axis and Y axis. The robot can take the following commands:
 * L -  The robot moves  one position left on  X axis.
 * R - The robot moves  one position right on  X axis.
 * U - The robot moves  one position up on  Y axis.
 * D - The robot moves  one position down on Y axis.
 *
 * Considering the robot is at position 0,0 When given a String like RRULDDDLR, what is the final location of the robot on the grid?"
 */
public class RobotPositionOnGrid {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0); // Create an instance of Robot
        String moveDirections = "RRULDDDLR";
        for (char direction : moveDirections.toCharArray()) {
            robot.move(direction);
        }
        System.out.println("(" + robot.getX() + ", " + robot.getY() + ")");
    }

    public static class Robot {
        private int x;
        private int y;

        public Robot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(char direction) {
            switch (direction) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid argument " + direction);
            }
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

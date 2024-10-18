package org.complex;


import java.util.ArrayList;
import java.util.List;

/**
A number of students, N of them, numbered 1 through N , sit in an order in a circle. Walking
around the circle many times the teacher sings a song. when teacher stop singing the song,
the student who has teacher at back must leave the circle and are out of the
game the length of the song is 2. Even though the circle thins out as this game is played, the teacher keeps singing and stop singing
around the circle until one student remains. The remained student will be the elected president.

input arrays: [1,1,1], [2,2,1],[4,2,1],[100,2,73]

array[0] is number of students
array[1] is length of the song
array[2] is expected output
 */
public class CircleStudentElection {

    public static void main(String[] args) {
        // Array Index:  0 = Number of students, 1 = Song Length, 2 = Expected Output
        int[][] inputArr = {{10, 3, 4}, {2, 2, 1}, {4, 2, 1}, {100, 2, 73}};

        for (int i = 0; i < inputArr.length; i++) {
            int numOfStudents = inputArr[i][0];
            int songLength = inputArr[i][1];
            int expectedOutput = inputArr[i][2];

            List<Integer> studentsList = new ArrayList<>();
            for (int j = 1; j <= numOfStudents; j++) {
                studentsList.add(j);
            }

            int result = findElectedStudentPosition(studentsList, songLength);
            System.out.println("For input " + numOfStudents + ", " + songLength + " => Expected: " + expectedOutput + ", Result: " + result);
        }
    }

    public static int findElectedStudentPosition(List<Integer> studentList, int songLength) {
        int currentPosition = 0; // Start at the first position

        while (studentList.size() > 1) {
            // Calculate the index of the student to be removed
            currentPosition = (currentPosition + songLength - 1) % studentList.size();
            studentList.remove(currentPosition);
        }

        return studentList.get(0);
    }
}


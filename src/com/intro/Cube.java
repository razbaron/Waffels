package com.intro;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cube {
    CubesFace front;
    CubesFace back;
    CubesFace right;
    CubesFace left;
    CubesFace up;
    CubesFace down;
    Map<CubesFace, RelevantCells []> mapOfFacesNeighbors;

   // This method creates a new Cube object and initial it
   public Cube() {
        front = new CubesFace(Color.BLUE);
        back = new CubesFace(Color.GREEN);
        right = new CubesFace(Color.ORANGE);
        left = new CubesFace(Color.RED);
        up = new CubesFace(Color.WHITE);
        down = new CubesFace(Color.YELLOW);
        mapOfFacesNeighbors = new HashMap<>();
        //Up is White
        mapOfFacesNeighbors.put(up,
                new RelevantCells[]{new RelevantCells(front,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(right, List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(back,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left,  List.of(new Point (0,0), new Point(0,1), new Point(0,2)))});
        //Down is Yellow
        mapOfFacesNeighbors.put(down,
                new RelevantCells[]{new RelevantCells(front,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right, List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(back,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(left,  List.of(new Point (2,2), new Point(2,1), new Point(2,0)))});
        //Front is Blue
        mapOfFacesNeighbors.put(front,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Right is Orange
        mapOfFacesNeighbors.put(right,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (0,2), new Point(1,2), new Point(2,2))),
                        new RelevantCells(back, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (0,2), new Point(1,2), new Point(2,2))),
                        new RelevantCells(front,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Back is Green
        mapOfFacesNeighbors.put(back,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Left is Red
        mapOfFacesNeighbors.put(left,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(front, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(back,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
    }

   // This method restarts a cube to it's original state
   public void cubeInit() {
       front.cubesFaceInit(Color.BLUE);
       back.cubesFaceInit(Color.GREEN);
       right.cubesFaceInit(Color.ORANGE);
       left.cubesFaceInit(Color.RED);
       up.cubesFaceInit(Color.WHITE);
       down.cubesFaceInit(Color.YELLOW);
    }

   // This method print every face of the cube as a two dimensional array
   public void printCube (){
        System.out.println("Up:");
        up.printFace();
        System.out.println("Down:");
        down.printFace();
        System.out.println("Left:");
        left.printFace();
        System.out.println("Right:");
        right.printFace();
        System.out.println("Front:");
        front.printFace();
        System.out.println("Back:");
        back.printFace();
    }

   // This method returns the cubes faces in an array
   public CubesFace[] getFaces (){
       CubesFace [] faceArr = {this.up, this.down, this.left, this.right, this.front, this.back};
       return(faceArr);
    }

   // This method will manege the rotation of a face and its neighbors
   public void rotateFace (CubesFace faceToRotate, int dir){
       System.out.println("This is a try to print the value that the point represent");
       //Just a test run
       if (faceToRotate == this.right)
           System.out.println("Truedat");
       if (faceToRotate.equals(this.right))
           System.out.println("Truedat 2.0");
       //I can make a switch case of that
       // f
       //Just a test run:
       System.out.println(mapOfFacesNeighbors.get(faceToRotate));
       mapOfFacesNeighbors.get(faceToRotate)[0].points.stream().forEach(point -> System.out.println(point.getLocation()));
       System.out.println(mapOfFacesNeighbors.get(faceToRotate).length-1);
       for (int i=0; i<mapOfFacesNeighbors.get(faceToRotate).length;i++){
           List<Color> colors = new ArrayList<Color>();
           colors=(mapOfFacesNeighbors.get(faceToRotate)[i].neighborName.getColorOfPointList(mapOfFacesNeighbors.get(faceToRotate)[i].points));
           colors.stream().forEach(color -> System.out.print(color+(",")));
           System.out.println();
       }
       return;
   }
}

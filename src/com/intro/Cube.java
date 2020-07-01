package com.intro;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cube {
   CubesFace front;
   CubesFace back;
   CubesFace right;
   CubesFace left;
   CubesFace up;
   CubesFace down;
   Map<CubesFace, RelevantCells []> mapOfFaceNeighbors;

   // This method creates a new Cube object and initial it
   public Cube() {
        front = new CubesFace(Color.BLUE);
        back = new CubesFace(Color.GREEN);
        right = new CubesFace(Color.ORANGE);
        left = new CubesFace(Color.RED);
        up = new CubesFace(Color.WHITE);
        down = new CubesFace(Color.YELLOW);
        mapOfFaceNeighbors = new HashMap<>();
        //Up is White
        mapOfFaceNeighbors.put(up,
                new RelevantCells[]{new RelevantCells(front,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(right, List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(back,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left,  List.of(new Point (0,0), new Point(0,1), new Point(0,2)))});
        //Down is Yellow
        mapOfFaceNeighbors.put(down,
                new RelevantCells[]{new RelevantCells(front,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right, List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(back,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(left,  List.of(new Point (2,2), new Point(2,1), new Point(2,0)))});
        //Front is Blue
        mapOfFaceNeighbors.put(front,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Right is Orange
        mapOfFaceNeighbors.put(right,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (0,2), new Point(1,2), new Point(2,2))),
                        new RelevantCells(back, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (0,2), new Point(1,2), new Point(2,2))),
                        new RelevantCells(front,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Back is Green
        mapOfFaceNeighbors.put(back,
                new RelevantCells[]{new RelevantCells(up,  List.of(new Point (0,0), new Point(0,1), new Point(0,2))),
                        new RelevantCells(left, List.of(new Point (2,0), new Point(1,0), new Point(0,0))),
                        new RelevantCells(down,  List.of(new Point (2,2), new Point(2,1), new Point(2,0))),
                        new RelevantCells(right,  List.of(new Point (0,2), new Point(1,2), new Point(2,2)))});
        //Left is Red
        mapOfFaceNeighbors.put(left,
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
   public void rotation (CubesFace face, int dir) {
       //compute dir so it won be over 4
       System.out.println("Starting rotation");
       //face.rotate(dir);
       rotateNeighbors(face, dir);
       System.out.println("Rotation is done");
       return;
   }

   // This method is rotating the neighbors of a cubeFace
   private void rotateNeighbors (CubesFace face, int dir){
       //mapOfFaceNeighbors.get(face)[0].points.stream().forEach(point -> System.out.println(point.getLocation()));
       for (int i=0;i<dir;i++){
           List<Color> colorsToSave = new ArrayList<Color>();
           //Should I use a number?
           colorsToSave=mapOfFaceNeighbors.get(face)[3].neighborName.getColorOfPointList(mapOfFaceNeighbors.get(face)[3].points);

           for (int j = 0; j< mapOfFaceNeighbors.get(face).length; j++){
               List<Color> colorsToPut = new ArrayList<Color>();
               colorsToPut=colorsToSave;
               colorsToSave=mapOfFaceNeighbors.get(face)[j].neighborName.getColorOfPointList(mapOfFaceNeighbors.get(face)[j].points);
               mapOfFaceNeighbors.get(face)[j].neighborName.replaceColorList(mapOfFaceNeighbors.get(face)[j].points,colorsToPut);
           }


       }
       System.out.println("Neighbor rotation is done!");

       return;
   }
}

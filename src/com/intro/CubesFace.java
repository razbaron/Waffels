package com.intro;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CubesFace {
    //Building the face object, two dimensional enum array. The object of the cube will use six of me

    //private Color topMiddle;
    private int cubesSize=3;
    private Color [][]  face = new Color [cubesSize][cubesSize];

    //Constructor
    public CubesFace (Color c) {
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                face[i][j]=c;
            }
        }
    }

    //This method initial the face it is given
    public void cubesFaceInit (Color c){
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                face[i][j]=c;
            }
        }
    }

    //This method prints a face that it is gives
    public void printFace () {
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                System.out.print(face[i][j]);
                if(j<face[0].length-1)
                    System.out.print(", ");

            }
            System.out.println();
        }
        System.out.println();
    }

    public int faceSizeRow(){
        return face.length;
    }
    public int faceSizeCul(){
        return face[0].length;
    }

    //This method is not complete 21.6.20
    public boolean isFaceSolved(){
        Color sample=face[0][0];
        for(int i=0;i<face.length;i++){
            for (int j=0;j<face[0].length;j++){
                if (sample!=face[i][j])
                    return false;
            }
        }
        return true;
    }
    public Color getFaceColor (){
        return face[1][1];
    }

    // This method will rotate only the face without neighbor cells
    public void rotate(int dir) {
        Color [][]  newFace = new Color [cubesSize][cubesSize];
        // I'll have two faces, one that I'll define and this
//        faceAfterRotation[1,1]=this[1,1];
        face=newFace;
    }

    //This method gets a point on a face and return it's color content
    public Color getColorOfPoint(Point pointInArray) {
        return face[(int)pointInArray.getX()][(int)pointInArray.getY()];
    }

    //This method gets a list of point on the face and return the color content of each
    public List<Color> getColorOfPointList (List<Point> points){
        List<Color> listOfColors = new ArrayList<Color>();
        points.stream().forEach(point -> listOfColors.add(this.getColorOfPoint(point)));
        return listOfColors;
    }
/* 20.6.20 this is a nice way that Rotem showed me
    public List<Color> getColorOfPoints(List<Point> points) {
        return points.stream()
                .map(point -> getColorOfPoint(point))
                .collect(Collectors.toList());
    }

 */
}



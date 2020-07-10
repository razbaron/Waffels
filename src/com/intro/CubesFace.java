package com.intro;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CubesFace {
    //Building the face object, two dimensional enum array. The object of the cube will use six of me

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
    public void rotate (int dir) {
        for (int j=0;j<dir;j++){
            CubesFace tempFace = this.copyMe();
            for (int i=0;i<tempFace.face[0].length;i++)
                face[i][2]=tempFace.face[0][i];
            for (int i=0;i<tempFace.face[1].length;i++)
                face[i][1]=tempFace.face[1][i];
            for (int i=0;i<tempFace.face[2].length;i++)
                face[i][0]=tempFace.face[2][i];
        }
        return;
    }

    //This method will copy one face to the other while keeping the at different places at memory
    private CubesFace copyMe (){
        CubesFace copyTo = new CubesFace(Color.WHITE);
        for (int i=0;i<this.face.length;i++)
            for (int j=0;j<this.face[i].length;j++)
                copyTo.face[i][j]=this.face[i][j];
        return copyTo;
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

    //This method will get a list of colors and insert them to the list of points it gets
    public void replaceColorList(List<Point> points, List<Color> temp) {
        if (points.size() != temp.size())
            System.out.println("replaceColorList method in CubesFace has a problem");
        for (int i=0;i<points.size();i++)
            this.face [(int)points.get(i).getX()][(int)points.get(i).getY()] = temp.get(i);
        return;
    }


/* 20.6.20 this is a nice way that Rotem showed me
    public List<Color> getColorOfPoints(List<Point> points) {
        return points.stream()
                .map(point -> getColorOfPoint(point))
                .collect(Collectors.toList());
    }

 */
}



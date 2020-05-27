package com.intro;

public class CubesFace {
    //Building the face object, two dimensional enum array. The object of the cube will use six of me

    //private Color topMiddle;
    private int cubesSize=3;
    private Color [][]  face = new Color [cubesSize][cubesSize];
    public CubesFace (Color c) {
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                face[i][j]=c;
            }
        }
    }
    public void cubesFaceInit (Color c){
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                face[i][j]=c;
            }
        }
    }

    public void printFace () {
        for(int i=0;i<face.length;i++){
            for(int j=0;j<face[0].length;j++){
                System.out.print(face[i][j]);
                if(j<face[0].length-1)
                    System.out.print(", ");

            }
            System.out.println("");
        }
        System.out.println();
    }
    public int faceSizeRow(){
        return face.length;
    }
    public int faceSizeCul(){
        return face[0].length;
    }
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

}



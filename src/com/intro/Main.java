package com.intro;

public class Main {

    public static void main(String[] args) {
	    System.out.println("I'll be the main");
        //Here we go
        Cube temp = new Cube();
        System.out.println("The cube was created, will initialize");
        //Initializing the Cube
        temp.cubeInit();
        System.out.println("I'll print the cube");
        temp.printCube();
        CubesFace justForFun = new CubesFace(Color.BLUE);
        System.out.println(temp.up.faceSizeRow());
        System.out.println(temp.up.faceSizeCul());
        //Printing the cube
        CubesFace [] facesArr = new CubesFace[6];
        facesArr=temp.getFaces();
        for (int i=0;i<facesArr.length;i++){
            facesArr[i].printFace();
        }
        //Starting to code the rotation 1.6.2020
        //direction can be clockwise -> 1 or counterclockwise -> -1 will be determined by a int
        int direction =1;
        //direction is how much you want to rotate clockwise, for counter clockwise direction will equal 3
        temp.rotateFace(temp.right, direction);
    }
}

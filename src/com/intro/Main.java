package com.intro;

public class Main {


    public static void main(String[] args) {
	    System.out.println("I'll be the main");
        //Here we go
        Cube myCube = new Cube();
        System.out.println("The cube was created, will initialize");
        //Initializing the Cube
        myCube.cubeInit();
        System.out.println("I'll print the cube");
        myCube.printCube();
        CubesFace justForFun = new CubesFace(Color.BLUE);
        //System.out.println(myCube.up.faceSizeRow());
        //System.out.println(myCube.up.faceSizeCul());
        //Starting to code the rotation 1.6.2020

        int direction =5;
        //direction is how much you want to rotate clockwise, for counter clockwise direction will equal 3
        myCube.rotation(myCube.up, direction);
        myCube.printCube();
        myCube.rotation(myCube.front,direction);
        myCube.printCube();
    }
}

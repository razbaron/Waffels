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
        //System.out.println(temp.up.faceSizeRow());
        //System.out.println(temp.up.faceSizeCul());
        //Starting to code the rotation 1.6.2020

        int direction =1;
        //direction is how much you want to rotate clockwise, for counter clockwise direction will equal 3
        //temp.rotation(temp.up, direction);
        //temp.printCube();
        temp.rotation(temp.front,direction);
        temp.printCube();
    }
}

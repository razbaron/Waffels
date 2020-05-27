package com.intro;

public class Main {

    public static void main(String[] args) {
	    System.out.println("I'll be the main");
        //Here we go
        Cube temp = new Cube();
        //Initialazing the Cube
        temp.cubeInit();
        System.out.println("I'll print the cube");
        temp.printCube();
        CubesFace justForFun = new CubesFace(Color.BLUE);
        //ToDo compleate find justforfun size
        System.out.println(temp.up.faceSizeRow());
        System.out.println(temp.up.faceSizeCul());
        //Printing the cube
        CubesFace [] facesArr = new CubesFace[6];
        facesArr=temp.getFaces();
        for (int i=0;i<facesArr.length;i++){
            facesArr[i].printFace();
        }

    }
}

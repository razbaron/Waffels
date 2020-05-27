package com.intro;

public class Cube {
    CubesFace front;
    CubesFace back;
    CubesFace right;
    CubesFace left;
    CubesFace up;
    CubesFace down;

    public Cube() {
        front = new CubesFace(Color.WHITE);
        back = new CubesFace(Color.YELLOW);
        right = new CubesFace(Color.GREEN);
        left = new CubesFace(Color.BLUE);
        up = new CubesFace(Color.RED);
        down = new CubesFace(Color.ORANGE);
    }
    public void cubeInit() {
        front.cubesFaceInit(Color.WHITE);
        back.cubesFaceInit(Color.YELLOW);
        right.cubesFaceInit(Color.GREEN);
        left.cubesFaceInit(Color.BLUE);
        up.cubesFaceInit(Color.RED);
        down.cubesFaceInit(Color.ORANGE);
    }

    private CubesFace facesNeighbors (Cube temp, CubesFace findMyNeighbors){
        System.out.println("");
        return findMyNeighbors;
    }

   public CubesFace[] getFaces (){
       CubesFace [] faceArr = {this.up, this.down, this.left, this.right, this.front, this.back};
       return(faceArr);
    }
/*
    public boolean isCubeSolved (){
        return true;
    }
*/
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

}

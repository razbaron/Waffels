package com.intro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//@ExtendWith(MockitoExtension.class)

public class CubesTest {

//    @Mock
//    private CubesFace up;
    @Test
    void cubeExistTest (){
        Cube temp= new Cube();
        Assertions.assertNotNull(temp);
    }
    @Test
    void cubesSizeTest (){
        Cube temp= new Cube();
        boolean allSameSize=true;
        int size=3;
        int sizeTemp=0;
    }
/*
    @Test
    void isFaceSolvedTest (){
        Cube temp= new Cube();
        when(up.isFaceSolved()).thenReturn(true);
        Assertions.assertEquals(true,(temp.isCubeSolved()).);
    }
*/

}

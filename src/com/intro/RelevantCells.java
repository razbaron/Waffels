package com.intro;

import java.awt.*;
import java.util.List;

public class RelevantCells {
    CubesFace neighborName;
    List<Point> points;
    public RelevantCells (CubesFace neighborName, List<Point> points){
        this.neighborName=neighborName;
        this.points=points;
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BullishDrawingProgramTest {

    private BullishDrawingProgram drawingProgram = new BullishDrawingProgram();

    @Test
    void testInitialize() {
        int length = 3;
        int width = 3;
        drawingProgram.initialize(3, 3);
        assertNotNull(drawingProgram.canvas);
        assertEquals(length, drawingProgram.length);
        assertEquals(width, drawingProgram.width);
    }

    @Test
    void testDrawLine() {
        drawingProgram.initialize(3, 3);
        drawingProgram.drawLine(0, 0, 0, 2);
        assertEquals('x', drawingProgram.canvas[0][0]);
        assertEquals('x', drawingProgram.canvas[0][1]);
        assertEquals('x', drawingProgram.canvas[0][2]);
    }

    @Test
    void testDrawRectangle() {
        drawingProgram.initialize(3,3);
        drawingProgram.drawRectangle(0,0,1,1);
        assertEquals('x', drawingProgram.canvas[0][0]);
        assertEquals('x', drawingProgram.canvas[1][1]);
        assertEquals('x', drawingProgram.canvas[0][1]);
        assertEquals('x', drawingProgram.canvas[1][0]);
        assertEquals(' ', drawingProgram.canvas[2][0]);
        assertEquals(' ', drawingProgram.canvas[0][2]);
    }

    @Test
    void testBucketFill() {
        drawingProgram.initialize(3,3);
        drawingProgram.drawRectangle(0,0,1,1);
        drawingProgram.bucketFill(2,2,'z');
        assertEquals('z', drawingProgram.canvas[2][0]);
        assertEquals('z', drawingProgram.canvas[0][2]);
        assertEquals('z', drawingProgram.canvas[2][2]);
        assertEquals('x', drawingProgram.canvas[1][1]);
    }

}
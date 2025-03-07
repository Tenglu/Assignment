package org.example

import spock.lang.Specification
import spock.lang.Subject


class BullishDrawingProgramSpec extends Specification {

    @Subject
    private BullishDrawingProgram drawingProgram

    def setup() {
        this.drawingProgram = new BullishDrawingProgram()
    }

    def "initialize"() {
        given:
        def length = 3
        def width = 3

        when:
        drawingProgram.initialize(length, width)

        then:
        drawingProgram.length == length
        drawingProgram.width == width
    }

    def "should draw a line"() {
        given:
        drawingProgram.initialize(3, 3)

        when:
        drawingProgram.drawLine(x1, y1, x2, y2)

        then:
        drawingProgram.canvas[0] == row1 as char[]
        drawingProgram.canvas[1] == row2 as char[]
        drawingProgram.canvas[2] == row3 as char[]

        where:
        x1 | y1 | x2 | y2 | row1            | row2            | row3
        0  | 0  | 0  | 2  | ['x', 'x', 'x'] | [' ', ' ', ' '] | [' ', ' ', ' ']
        0  | 0  | 2  | 0  | ['x', ' ', ' '] | ['x', ' ', ' '] | ['x', ' ', ' ']
        0  | 1  | 2  | 0  | [' ', ' ', ' '] | [' ', ' ', ' '] | [' ', ' ', ' ']

    }

    def "should draw a rectangle"() {
        given:
        drawingProgram.initialize(3, 3)

        when:
        drawingProgram.drawRectangle(0, 0, 1, 1)

        then:
        drawingProgram.canvas[0] == ['x', 'x', ' '] as char[]
        drawingProgram.canvas[1] == ['x', 'x', ' '] as char[]
        drawingProgram.canvas[2] == [' ', ' ', ' '] as char[]
    }

    def "should fill bucket"() {
        given:
        drawingProgram.initialize(3, 3)
        drawingProgram.drawRectangle(0, 0, 1, 1);

        when:
        drawingProgram.bucketFill(x, y, 'z' as char)

        then:
        drawingProgram.canvas[0] == row1 as char[]
        drawingProgram.canvas[1] == row2 as char[]
        drawingProgram.canvas[2] == row3 as char[]

        where:
        x | y | row1            | row2            | row3
        2 | 2 | ['x', 'x', 'z'] | ['x', 'x', 'z'] | ['z', 'z', 'z']
        1 | 1 | ['z', 'z', ' '] | ['z', 'z', ' '] | [' ', ' ', ' ']

    }

    def "test if can read input"() {
        given:
        def input = "C 3 3 \nQ"
        def inputStream = new ByteArrayInputStream(input.getBytes())
        System.setIn(inputStream)

        when:
        drawingProgram.readInput()

        then:
        drawingProgram.canvas != null
    }

}

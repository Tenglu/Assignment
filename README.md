#Bullish Canvas Program

## How to Run
1. Open a terminal or command
2. Navigate to the directory '/src/main/java'. 
3. Generate class file by using the command: javac org/example/BullishDrawingProgram.java
4. Run the command: java org.example.BullishDrawingProgram
5. Example command sequence: 
   6. C 5 5
   7. L 0 0 0 3
   8. R 1 1 3 3
   9. B 4 4 z
   10. Q


## Explanation
I use Both the Junit and groovy spock for unit testing. The groovy spock is the framework I mentioned in our first interview that we currently use it in our projects.
I just want to compare these two testing frameworks and demonstrate how Groovy Spock can provide more organized and clear unit tests.
In this program, I achieved over 80% test coverage using the Spock framework.

## Comments
For drawing a line part, I'm not sure if a slash should be included. I chose not to include it to keep the program simple.
Below is the code for drawing a slash, and if we add it, we will also need to adjust the bucket fill function accordingly.

/* To draw a slash if needed
else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
   int dx = (x2 > x1) ? 1 : -1;
   int dy = (y2 > y1) ? 1 : -1;
   int x = x1;
   int y = y1;
   while (x != x2 + dx && y != y2 + dy) {
       canvas[y][x] = 'x';
       x += dx;
       y += dy;
   }
}
*/
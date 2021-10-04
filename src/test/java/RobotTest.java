import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class RobotTest {

    /* Create robot */
//    GridPosition gp = new GridPosition(2,3);
//    GridPosition gp2 = new GridPosition(2,3);
//    gp.equals(gp2);

    @Test
    public void testMock(){

        Calendar mockCalander = Mockito.mock(Calendar.class);

    }









    @Test
    public void turnLeftWhenNorth() {
        Orientation initialOrientation = Orientation.NORTH;//mock orientation object;//instantiate mock object
                //set up expectation as north
        GridPosition mockGridPosition = Mockito.mock(GridPosition.class);

//        @InjectMocks
//        GridPosition gridPosition;
//
//        @Mock
//        Robot robot;

              // define the expectation on the mock

        //When mock grid position is called with getX, then return 5
        when(mockGridPosition.getX()).thenReturn(5);
        //When mock grid position is called with getY, then return 6
        when(mockGridPosition.getY()).thenReturn(6);

        Robot robot = new Robot(mockGridPosition, initialOrientation);
        robot.advance();

        assertEquals(robot.getGridPosition().getX(), 5 );
        assertEquals(robot.getGridPosition().getY(), 6 );
        assertEquals(Orientation.WEST, robot.getOrientation());
        assertEquals(mockGridPosition, robot.getGridPosition());
    }












    @Test
    public void atOriginFacingNorth() {
        Orientation initialOrientation = Orientation.NORTH;
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Test
    public void atNegativePositionFacingSouth() {
        GridPosition initialGridPosition = new GridPosition(-1, -1);
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    /* Rotating clockwise */

    @Test
    public void changesNorthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesEastToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesSouthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesWestToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Rotating counter-clockwise */

    @Test
    public void changesNorthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesWestToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesSouthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesEastToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Moving forward one */

    @Test
    public void facingNorthIncrementsY() {
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, 1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingSouthDecrementsY() {
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, -1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingEastIncrementsX() {
        Orientation initialOrientation = Orientation.EAST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingWestDecrementsX() {
        Orientation initialOrientation = Orientation.WEST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(-1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    /* Follow series of instructions */

    @Test
    public void movingEastAndNorthFromReadme() {
        Robot robot = new Robot(new GridPosition(7, 3), Orientation.NORTH);

        robot.simulate("RAALAL");

        GridPosition expectedGridPosition = new GridPosition(9, 4);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }


    @Test
    public void movingWestAndNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        GridPosition expectedGridPosition = new GridPosition(-4, 1);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void movingWestAndSouth() {
        Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        GridPosition expectedGridPosition = new GridPosition(-3, -8);
        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void movingEastAndNorth() {
        Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        GridPosition expectedGridPosition = new GridPosition(11, 5);
        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

}
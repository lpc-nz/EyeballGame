package assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    public static class TestGameHoldsLevels {
        Game game = new Game();

        void addTestLevel1() {
            game.addLevel(1, 5);
        }

        void addTestLevel2() {
            game.addLevel(7, 3);
        }

        @Test
        void testGetLevelWidth() {
            this.addTestLevel1();
            int expectedWidth = 5;
            int actualWidth = game.getLevelWidth();
            assertEquals(expectedWidth, actualWidth);
        }

        @Test
        void testGetLevelHeight() {
            this.addTestLevel1();
            int expectedHeight = 1;
            int actualHeight = game.getLevelHeight();
            assertEquals(expectedHeight, actualHeight);
        }

        @Test
        void testGetLevelCountWithOneLevel() {
            this.addTestLevel1();
            int expectedLevelCount = 1;
            int actuallevelCount = game.getLevelCount();
            assertEquals(expectedLevelCount, actuallevelCount);
        }


        @Test
        void testGetLevelCountWithTwoLevels() {
            this.addTestLevel1();
            this.addTestLevel2();
            int expectedLevelCount = 2;
            int actuallevelCount = game.getLevelCount();
            assertEquals(expectedLevelCount, actuallevelCount);
        }

        @Test
        void testMostRecentlyAddedLevelIsCurrentLevelbyCheckingSize() {
            this.addTestLevel1();
            this.addTestLevel2();
            int[] expectedLevelSize = {7,3};
            int[] actualLevelSize = {game.getLevelHeight(), game.getLevelWidth()};
            assertArrayEquals(expectedLevelSize, actualLevelSize);
        }


        @Test
        void testSettingLeveltoToolargeNumberThrowsException() {
            this.addTestLevel1();
            this.addTestLevel2();
            assertThrows(IllegalArgumentException.class, () -> {game.setLevel(42);});
        }
    }

     public static class TestLevelHoldsGoals {

        Game game = new Game();

        void add7High3WideLevel() {
            game.addLevel(7, 3);
        }

        @Test
        void testAddingOneGoalIncreasesGoalCountTo1() {
            this.add7High3WideLevel();
            game.addGoal(4, 2);
            int expectedGoalCount = 1;
            int actualGoalCount = game.getGoalCount();
            assertEquals(expectedGoalCount, actualGoalCount);

        }

        @Test
        void testAddingOneGoalputsGoalAtExpectedPosition() {
            this.add7High3WideLevel();
            game.addGoal(4, 2);
            boolean hasGoal = game.hasGoalAt(4, 2);
            assertTrue(hasGoal);
        }

        @Test
        void testAddingTwoGoalIncreasesGoalCountto2() {
            this.add7High3WideLevel();
            game.addGoal(4, 2);
            game.addGoal(6, 1);
            int expectedGoalCount = 2;
            int actualGoalCount = game.getGoalCount();
            assertEquals(expectedGoalCount, actualGoalCount);

        }

        @Test
        void testAddingTwoGoalsPutsGoalsAtExpectedPositions() {
            this.add7High3WideLevel();
            game.addGoal(4, 2);
            game.addGoal(6, 1);
            boolean[] expectedHasGoals = {true, true};
            boolean[] actualHasGoals = {game.hasGoalAt(4, 2), game.hasGoalAt(6, 1)};
            assertArrayEquals(expectedHasGoals, actualHasGoals);
        }

        @Test
        void testNewGamehas0CompletedGoals() {
            this.add7High3WideLevel();
            game.addGoal(4, 2);
            game.addGoal(6, 1);
            int expectedGoalCount = 0;
            int actualGoalCount = game.getCompletedGoalCount();
            assertEquals(expectedGoalCount, actualGoalCount);
        }


    }

    public static class TestGameHoldsSquares {

        Game game = new Game();

        private void setup() {
            game = new Game();
            game.addLevel(9, 1);
            game.addSquare(new BlankSquare(), 0, 0);
            game.addSquare(new BlankSquare(), 1, 0);
            game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 2, 0);
            game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 3, 0);
            game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 4, 0);
            game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 5, 0);
            game.addSquare(new PlayableSquare(Color.PURPLE, Shape.LIGHTNING), 6, 0);
            game.addSquare(new BlankSquare(), 7, 0);
            game.addSquare(new BlankSquare(), 8, 0);
        }

//        @Test
//        void testAddingSquareOutsideLevelWidthThrowsException() {
//            game = new Game();
//            game.addLevel(9, 1);
//            assertThrows(IllegalArgumentException.class, () -> {game.addSquare(new BlankSquare(), 0, 4);});
//        }
//        @Test
//        void testAddingSquareOutsideLevelHeightThrowsException() {
//            game = new Game();
//            game.addLevel(9, 1);
//            assertThrows(IllegalArgumentException.class, () -> {game.addSquare(new BlankSquare(), 22, 0);});
//        }
//
//
//        @Test
//        void testColoursAreAsAdded() {
//            setup();
//            Color[] expectedColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLANK, Color.PURPLE};
//            Color[] actualColors = {game.getColorAt(2, 0),
//                    game.getColorAt(3, 0),
//                    game.getColorAt(4, 0),
//                    game.getColorAt(5, 0),
//                    game.getColorAt(7, 0),
//                    game.getColorAt(6, 0)
//            };
//            assertArrayEquals(expectedColors, actualColors);
//        }
//
//        @Test
//        void testShapesAreAsAdded() {
//            setup();
//            Shape[] expectedShapes = {Shape.DIAMOND, Shape.CROSS, Shape.STAR, Shape.FLOWER, Shape.BLANK, Shape.LIGHTNING};
//            Shape[] actualShapes = {game.getShapeAt(2, 0),
//                    game.getShapeAt(3, 0),
//                    game.getShapeAt(4, 0),
//                    game.getShapeAt(5, 0),
//                    game.getShapeAt(7, 0),
//                    game.getShapeAt(6, 0)
//            };
//            assertArrayEquals(expectedShapes, actualShapes);
//        }
//
//    }
//
//    public static class TestGameHoldsEyeball {
//        Game game = new Game();
//        void add7High3WideLevel() {
//            game.addLevel(7, 3);
//        }
//
//        @Test
//        void testAddingEyeballOutsideHeightThrowsException() {
//            this.add7High3WideLevel();
//            assertThrows(IllegalArgumentException.class, () -> {game.addEyeball(9, 2, Direction.UP);});
//        }
//
//        @Test
//        void testAddingEyeballOutsideWidthThrowsException() {
//            this.add7High3WideLevel();
//            assertThrows(IllegalArgumentException.class, () -> {game.addEyeball(6, 5, Direction.UP);});
//        }
//
//
//        @Test
//        void testAddingEyeballPutsItWhereExpected() {
//            this.add7High3WideLevel();
//            game.addEyeball(4, 2, Direction.UP);
//            int[] expectedRowColumn = {4,2};
//            int[] actualRowColumn = {game.getEyeballRow(), game.getEyeballColumn()};
//            assertArrayEquals(expectedRowColumn, actualRowColumn);
//        }
//
//        @Test
//        void testAddingEyeballFacingUpFacesUP() {
//            this.add7High3WideLevel();
//            game.addEyeball(4, 2, Direction.UP);
//            Direction expectedDirection = Direction.UP;
//            Direction actualDirection = game.getEyeballDirection();
//            assertEquals(expectedDirection, actualDirection);
//        }
//
//        @Test
//        void testAddingEyeballFacingDOWNFacesDOWN() {
//            this.add7High3WideLevel();
//            game.addEyeball(4, 2, Direction.DOWN);
//            Direction expectedDirection = Direction.DOWN;
//            Direction actualDirection = game.getEyeballDirection();
//            assertEquals(expectedDirection, actualDirection);
//        }
//
//        @Test
//        void testAddingEyeballFacingLEFTFacesLEFT() {
//            this.add7High3WideLevel();
//            game.addEyeball(4, 2, Direction.LEFT);
//            Direction expectedDirection = Direction.LEFT;
//            Direction actualDirection = game.getEyeballDirection();
//            assertEquals(expectedDirection, actualDirection);
//        }
//
//        @Test
//        void testAddingEyeballFacingRIGHTFacesRIGHT() {
//            this.add7High3WideLevel();
//            game.addEyeball(4, 2, Direction.RIGHT);
//            Direction expectedDirection = Direction.RIGHT;
//            Direction actualDirection = game.getEyeballDirection();
//            assertEquals(expectedDirection, actualDirection);
//        }
//
//
//
//    }
}



package se.lexicon.lasse78;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest
{
    @Test
    public void addTwoValues() {
        // Arrange
        double value1 = 50;
        double value2 = 100;

        // Act
        double result = App.calcAddValues(value1, value2);

        // Assert
        assertEquals(150, result, 0.0);
    }

    @Test
    public void addTwoNegativeValues() {
        // Arrange
        double value1 = -50;
        double value2 = -100;

        // Act
        double result = App.calcAddValues(value1, value2);

        // Assert
        assertEquals(result, -150, 0.0);
    }

    @Test
    public void addTwoDecimalValues() {
        // Arrange
        double value1 = 5.5d;
        double value2 = 4.25d;

        // Act
        double result = App.calcAddValues(value1, value2);

        // Assert
        assertEquals(9.75, result, 0.0);
    }

    @Test
    public void addValuesFromArray() {
        // Arrange
        double[] testArray = {1, 2, 3, 4, 5};

        // Act
        double result = App.calcAddValues(testArray);

        // Assert
        assertEquals(15, result, 0.0);
    }

    @Test
    public void addNegativeValuesFromArray() {
        // Arrange
        double[] testArray = {-1, -2, -3, -4, -5};

        // Act
        double result = App.calcAddValues(testArray);

        // Assert
        assertEquals(result, -15, 0.0);
    }

    @Test
    public void subtractTwoValues() {
        // Arrange
        double value1 = 5.5d;
        double value2 = 4.5d;

        // Act
        double result = App.calcSubtractValues(value1, value2);

        // Assert
        assertEquals(1, result, 0.0);
    }

    @Test
    public void subtractTwoNegativeValues() {
        // Arrange
        double value1 = -5.5d;
        double value2 = -4.5d;

        // Act
        double result = App.calcSubtractValues(value1, value2);

        // Assert
        assertEquals(result, -1, 0.0);
    }

    @Test
    public void subtractValuesFromArray() {
        // Arrange
        double[] testArray = {1, 2, 3, 4, 5};

        // Act
        double result = App.calcSubtractValues(testArray);

        // Assert
        assertEquals(result, -13, 0.0); // (1 - 2 - 3 - 4 - 5)
    }

    @Test
    public void subtractNegativeValuesFromArray() {
        // Arrange
        double[] testArray = {-1, -2, -3, -4, -5};

        // Act
        double result = App.calcSubtractValues(testArray);

        // Assert
        assertEquals(13, result, 0.0); // (-1 + 2 + 3 + 4 + 5)
    }

    @Test
    public void requiredTestForAssignmentSubtractValuesFromArray() {
        // Arrange
        double[] testArray = {-7, 5, 3};

        // Act
        double result = App.calcSubtractValues(testArray);

        // Assert
        assertEquals(result, -15, 0.0); // (-7 - 5 - 3)
    }

    @Test
    public void multiplyTwoValues() {
        // Arrange
        double value1 = 20;
        double value2 = 20;

        // Act
        double result = App.calcMultiplyValues(value1, value2);

        // Assert
        assertEquals(400, result, 0.0);
    }

    @Test
    public void multiplyNegativeValue() {
        // Arrange
        double value1 = -20;
        double value2 = 20;

        // Act
        double result = App.calcMultiplyValues(value1, value2);

        // Assert
        assertEquals(result, -400, 0.0);
    }

    @Test
    public void divideTwoValues() {
        // Arrange
        double value1 = 20;
        double value2 = 5;

        // Act
        double result = App.calcDivideValues(value1, value2);

        // Assert
        assertEquals(4.0d, result, 0.0);
    }

    @Test
    public void divideFloatValues() {
        // Arrange
        double value1 = 1;
        double value2 = 0.8;

        // Act
        double result = App.calcDivideValues(value1, value2);

        // Assert
        assertEquals(1.25, result, 0.0);
    }

    @Test
    public void divideByZero() {
        // Arrange
        double value1 = 1;
        double value2 = 0;

        // Act
        double result = App.calcDivideValues(value1, value2);

        // Assert
        assertEquals(result, -1, 0.0);
    }

    @Test
    public void hasArrayExpanded() {
        // Arrange
        double value = 65_535;
        double[] testArray = {1, 2, 3, 4, 5};
        int previousIndex = testArray.length;

        // Act
        testArray = App.expandArray(testArray, value);

        // Assert
        assertEquals((testArray.length - 1), previousIndex);
    }

    @Test
    public void hasArrayInputCorrectValue() {
        // Arrange
        double value = 32_768;
        double[] testArray = {1, 2, 3, 4, 5};

        // Act
        testArray = App.expandArray(testArray, value);

        // Assert
        assertEquals((testArray[testArray.length - 1]), value, 0.0);
    }
}
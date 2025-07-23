package org.example.fileprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static junit.framework.Assert.assertEquals;


public class ExpressionEvaluatorTest {
    @Test
    void testAddition() {
        assertEquals("9", ExpressionEvaluator.evaluate("4 + 5"));
    }

    @Test
    void testSubtraction() {
        assertEquals("1", ExpressionEvaluator.evaluate("9 - 8"));
    }

    @Test
    void testMultiplication() {
        assertEquals("16", ExpressionEvaluator.evaluate("4 * 4"));
    }

    @Test
    void testDivision() {
        assertEquals("3", ExpressionEvaluator.evaluate("9 / 3"));
    }

    @Test
    void testDivisionByZero() {
        assertEquals("0", ExpressionEvaluator.evaluate("10 / 0"));
    }

    @Test
    void testTextWithExpression() {
        assertEquals("The answer is 5", ExpressionEvaluator.evaluate("The answer is 3 + 2"));
    }

    @Test
    void testTextWithNoExpression() {
        assertEquals("Text with no expression", ExpressionEvaluator.evaluate("Text with no expression"));
    }

}

package org.example.fileprocessor;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("File Processor")
@Feature("Expression Evaluation")
@Story("Evaluate arithmetic expressions in strings")
public class ExpressionEvaluatorTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check addition: 4 + 5 = 9")
    void testAddition() {
        assertEquals("9", ExpressionEvaluator.evaluate("4 + 5"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check subtraction without spaces: 9-8 = 1")
    void testSubtraction() {
        assertEquals("1", ExpressionEvaluator.evaluate("9-8"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check multiplication: 4 * 4 = 16")
    void testMultiplication() {
        assertEquals("16", ExpressionEvaluator.evaluate("4 * 4"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check division: 9 / 3 = 3")
    void testDivision() {
        assertEquals("3", ExpressionEvaluator.evaluate("9 / 3"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check division by zero: 10 / 0 → 0 (according to specification)")
    void testDivisionByZero() {
        assertEquals("0", ExpressionEvaluator.evaluate("10 / 0"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check expression inside text: 'The answer is 3 + 2'")
    void testTextWithExpression() {
        assertEquals("The answer is 5", ExpressionEvaluator.evaluate("The answer is 3 + 2"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check string without expressions: 'Text with no expression'")
    void testTextWithNoExpression() {
        assertEquals("Text with no expression", ExpressionEvaluator.evaluate("Text with no expression"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check expression string with operator precedence")
    void testMultipleExpressions() {
        assertEquals("67", ExpressionEvaluator.evaluate("9*7+4"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check expression string with operator precedence and text")
    void TestMultipleExpressionsWithText() {
        assertEquals("Some text 3", ExpressionEvaluator.evaluate("Some text 8 + 4 - 9"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check expression string with brackets")
    void TestExpressionWithBrackets() {
        assertEquals("8", ExpressionEvaluator.evaluate("2*(2+2)"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check expression string with brackets and text")
    void TestExpressionWithTextAndBrackets() {
        assertEquals("some text 3", ExpressionEvaluator.evaluate("some text 3/(2-1)"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check multiple minus signs")
    void TestMultipleMinus() {
        assertEquals("9", ExpressionEvaluator.evaluate("14---5"));
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Check multiple brackets")
    void TestMultipleBrackets() {
        assertEquals("144", ExpressionEvaluator.evaluate("(4+4)*(2+(8*2))"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check if *1 equals *1")
    void TestMultiplyOne() {
        assertEquals("*1", ExpressionEvaluator.evaluate("*1"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check if 1 equals 1")
    void TestSingleTerm() {
        assertEquals("1", ExpressionEvaluator.evaluate("1"));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check if ---1 equals -1")
    void TestMultipleMinusOne() {
        assertEquals("-1", ExpressionEvaluator.evaluate("---1"));
    }

}

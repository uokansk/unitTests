package calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    public static void initAll() {
        // Здесь могут быть глобальные операции инициализации
    }

    @AfterAll
    public static void tearDownAll() {
        // Здесь могут быть глобальные операции завершения
    }

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("Проверка суммирования")
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Проверка вычитания")
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @DisplayName("Проверка умножения")
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @DisplayName("Проверка деления")
    void testDivide() {
        assertEquals(2.0, calculator.divide(4, 2));
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }

//    @Test
//    @DisplayName("Этот тест отключен")
//    public void disabledTest() {
//        fail("Не будет выполнен");
//    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("Параметризованный тест для умножения на 2")
    void testMultiplyWithParameters(int arg) {
        assertEquals(arg * 2, calculator.multiply(arg, 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    @DisplayName("Параметризованный тест для суммирования")
    public void parameterizedTest(int arg) {
        assertEquals(arg + 2, calculator.add(arg, 2));
    }

    @Test
    @DisplayName("Проверка истинного условия")
    void testAssertTrue() {
        assertTrue(calculator.add(2, 2) == 4);
    }

    @Test
    @DisplayName("Проверка ложного условия")
    void testAssertFalse() {
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    @DisplayName("Проверка наличия объекта")
    void testAssertNotNull() {
        assertNotNull(calculator);
    }

    @Test
    @DisplayName("Проверка отсутствия объекта")
    void testAssertNull() {
        calculator = null;
        assertNull(calculator);
    }

    @Test
    @DisplayName("Проверка равенства массивов")
    void testAssertArrayEquals() {

        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);

    }

//    @Test
//    @DisplayName("Проверка отсутствие покупками")
//    void testNoPurchase() {
//        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(0.0, 1));
//
//    }

    @Test
    @DisplayName("Проверка отсутствие покупками")
    void testLittlePurchase() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(99.99, 0));

    }


    @Test
    @DisplayName("Проверка отсутствие покупками")
    void testNegativePurchase() {
        assertEquals(900.0, calculator.calculateDiscount(1000, 10));


    }

}
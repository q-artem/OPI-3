package lab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit-тесты для класса Result.
 * Проверяют конструктор, геттеры и сеттеры.
 */
public class ResultTest {

    @Test
    public void constructor_setsAllFields() {
        Result r = new Result(1, 2, 3.5, 2.0, true);
        assertEquals(1,   r.getId());
        assertEquals(2,   r.getX());
        assertEquals(3.5, r.getY(),  0.001);
        assertEquals(2.0, r.getR(),  0.001);
        assertTrue(r.isHit());
    }

    @Test
    public void setters_changeValues() {
        Result r = new Result(0, 0, 0, 0, false);
        r.setId(10);
        r.setX(-3);
        r.setY(1.1);
        r.setR(2.5);
        r.setHit(true);

        assertEquals(10,  r.getId());
        assertEquals(-3,  r.getX());
        assertEquals(1.1, r.getY(), 0.001);
        assertEquals(2.5, r.getR(), 0.001);
        assertTrue(r.isHit());
    }

    @Test
    public void hitFalse_isPreserved() {
        Result r = new Result(5, 1, -1.0, 3.0, false);
        assertFalse(r.isHit());
    }

    @Test
    public void negativeCoordinates_stored() {
        Result r = new Result(2, -5, -3.14, 1.5, false);
        assertEquals(-5,    r.getX());
        assertEquals(-3.14, r.getY(), 0.001);
    }
}

package lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit-тесты для AreaBean.checkHit().
 * Проверяем три области попадания:
 *   — прямоугольник во II четверти (x<=0, y>=0, x+r>=y)
 *   — прямоугольник в III четверти (x<=0, y<=0, x>=-r/2, y>=-r)
 *   — четверть круга в IV четверти (x>=0, y<=0, x²+y²<=r²)
 */
public class AreaBeanTest {

    private AreaBean bean;

    @Before
    public void setUp() {
        bean = new AreaBean(null);
    }

    // II четверть: прямоугольник

    @Test
    public void quadrantII_insideRectangle() {
        bean.setX(-1);
        bean.setY(0.5);
        assertTrue("Точка должна быть внутри прямоугольника Q2", bean.checkHit(2.0));
    }

    @Test
    public void quadrantII_onBoundary() {
        bean.setX(0);
        bean.setY(0);
        assertTrue("Угол прямоугольника Q2", bean.checkHit(1.0));
    }

    @Test
    public void quadrantII_outsideBecauseYTooHigh() {
        bean.setX(-1);
        bean.setY(1.5);
        assertFalse("y > x+r — вне прямоугольника Q2", bean.checkHit(2.0));
    }

    // III четверть: прямоугольник

    @Test
    public void quadrantIII_insideRectangle() {
        bean.setX(-1);
        bean.setY(-1.0);
        assertTrue("Точка внутри прямоугольника Q3", bean.checkHit(2.0));
    }

    @Test
    public void quadrantIII_outsideBecauseXTooLeft() {
        bean.setX(-2);
        bean.setY(-1.0);
        assertFalse("x < -r/2 — вне прямоугольника Q3", bean.checkHit(2.0));
    }

    @Test
    public void quadrantIII_outsideBecauseYTooLow() {
        bean.setX(-1);
        bean.setY(-3.0);
        assertFalse("y < -r — вне прямоугольника Q3", bean.checkHit(2.0));
    }

    // IV четверть: четверть круга

    @Test
    public void quadrantIV_insideCircle() {
        bean.setX(1);
        bean.setY(-1.0);
        assertTrue("Точка внутри четверти круга Q4", bean.checkHit(2.0));
    }

    @Test
    public void quadrantIV_onCircleBoundary() {
        bean.setX(2);
        bean.setY(0.0);
        assertTrue("Точка на границе круга Q4", bean.checkHit(2.0));
    }

    @Test
    public void quadrantIV_outsideCircle() {
        bean.setX(2);
        bean.setY(-2.0);
        assertFalse("Точка вне круга Q4 (x²+y² > r²)", bean.checkHit(2.0));
    }

    // I четверть: не входит ни в одну область

    @Test
    public void quadrantI_alwaysMiss() {
        bean.setX(1);
        bean.setY(1.0);
        assertFalse("Точка в Q1 — вне всех областей", bean.checkHit(2.0));
    }

    @Test
    public void zeroRadius_originIsHit() {
        bean.setX(0);
        bean.setY(0.0);
        assertTrue("При r=0 начало координат входит в Q2-прямоугольник (x+r=y=0)", bean.checkHit(0.0));
    }
}

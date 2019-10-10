package importsandPackages1

import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import util.TIMEOUT
import util.runAndCheckSystemOutput
import kotlin.math.sqrt

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestEquilateralTriangle {
  private fun checkArea(side: Double) {
    val triangleClass = ClassLoader.getSystemClassLoader().loadClass("pythagorean.EquilateralTriangle")
    val constructors = triangleClass.constructors
    if (constructors.isEmpty()) {
      throw AssertionError("The class EquilateralTriangle should have a constructor")
    }
    val constructor = constructors[0]
    val et = constructor.newInstance(side)
    val expected = sqrt(3.0) / 4 * side * side

    val areaMethod = triangleClass.getMethod("area")
    val areaResult = areaMethod.invoke(et) as? Double
      ?: throw AssertionError("area member function should return Double as a result")
    Assert.assertEquals("Wrong result for side $side", expected, areaResult, 0.00000000000001)
  }

  @Test(timeout = TIMEOUT)
  fun testArea1() = checkArea(1.0)

  @Test(timeout = TIMEOUT)
  fun testArea2() = checkArea(2.0)

  @Test(timeout = TIMEOUT)
  fun testArea3() = checkArea(3.0)

  @Test(timeout = TIMEOUT)
  fun testArea4() = checkArea(4.0)

  @Test(timeout = TIMEOUT)
  fun testMain() {
    runAndCheckSystemOutput(
      "'main' function in 'Main.kt' should print 'et.area()' value",
      "0.4330127018922193") {
      main()
    }
  }
}
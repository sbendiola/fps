package fps.excercisesChapter2

import org.scalatest.Matchers._
import org.scalatest.Suite
import org.scalatest.prop.PropertyChecks

class Chapter2Suite extends Suite with PropertyChecks {

  forAll { (a: Int, b: Int) =>

    whenever (a < b) {
      isSorted(a :: b :: Nil, (x:Int , y:Int) => x <= y) should be (true)
    }
  }

  forAll { items: List[Int] =>

    whenever (items.sorted != items) {
      isSorted(items, (x:Int , y:Int) => x <= y) should be (false)
    }
  }

  forAll { items: List[Int] =>

    val sorted = items.sorted
    whenever (true) {
      isSorted(sorted, (x:Int , y:Int) => x <= y) should be (true)
    }
  }

}

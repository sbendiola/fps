package fps.excercisesChapter3

import org.scalatest.Matchers._
import org.scalatest.Suite
import org.scalatest.prop.PropertyChecks

class Chapter3Suite extends Suite with PropertyChecks {

  forAll { (a: Int, b: Int, c: Int) =>
    init(a :: b :: c:: Nil) should be (List(a, b))
  }

  forAll { (a: Int, b: Int) =>
      init(a :: b :: Nil) should be (List(a))
  }

  forAll { a: Int =>
    init(a :: Nil) should be (Nil)
  }

}

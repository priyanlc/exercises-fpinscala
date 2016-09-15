package fpinscalalib

import org.scalaexercises.Test
import org.scalacheck.Shapeless._
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapeless.HNil

class PropertyBasedTestingSpec extends Spec with Checkers {
  def `prop and asserts` = {
    check(Test.testSuccess(PropertyBasedTestingSection.propAndAssert _, 4 :: 4 :: true :: HNil))
  }

  def `gen choose int` = {
    PropertyBasedTestingSection.genChooseIntAssert(0, 0, 10, 10)
  }

  def `gen unit` = {
    check(Test.testSuccess(PropertyBasedTestingSection.genUnitAssert _, 42 :: "foo" :: HNil))
  }

  def `gen listOfN` = {
    check(Test.testSuccess(PropertyBasedTestingSection.genListOfN _, 10 :: List(42, 42, 42) :: HNil))
  }

  def `gen listOfN via flatMap` = {
    check(Test.testSuccess(PropertyBasedTestingSection.genListOfNViaFlatMap _, 0 :: 10 :: List(42) :: HNil))
  }
}
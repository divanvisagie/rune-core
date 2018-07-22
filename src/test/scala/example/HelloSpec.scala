package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }
}

class ElderFutharkTranslation extends FlatSpec with Matchers {
  val elderFuthark = new ElderFuthark()
  val translator = Translator()

  "ᚨ" should "translate to A" in {
    translator.translateToLatin("ᚨ", elderFuthark) shouldEqual "A"
  }

  "ᛒ" should "translate to latin B" in {
    translator.translateToLatin("ᛒ", elderFuthark) shouldEqual "B"
  }

  "ᚠᚢᛏᚺᚨᚱᚲ" should "translate to latin futhark" in {
    translator.translateToLatin("ᚠᚢᛏᚺᚨᚱᚲ", elderFuthark) shouldEqual "FUTHARK"
  }
}
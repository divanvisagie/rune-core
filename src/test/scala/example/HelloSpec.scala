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


  //To latin
  "ᚨ" should "translate to latin A" in {
    translator.translateToLatin("ᚨ", elderFuthark) shouldEqual "A"
  }

  "ᛒ" should "translate to latin B" in {
    translator.translateToLatin("ᛒ", elderFuthark) shouldEqual "B"
  }

  "ᚠᚢᚦᚨᚱᚲ" should "translate to latin FUTHARK" in {
    translator.translateToLatin("ᚠᚢᚦᚨᚱᚲ", elderFuthark) shouldEqual "FUTHARK"
  }

  //From latin
  "FUTHARK" should "translate to ᚠᚢᚦᚨᚱᚲ" in {
    translator.translateFromLatin("FUTHARK", elderFuthark) shouldEqual "ᚠᚢᚦᚨᚱᚲ"
  }

  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" should "translate to ᚨᛒᚲᛞᛖᚠᚷᚺᛜᛃᚲᛚᛗᚾᛟᛈᚲᚱᛋᛏᚢᚠᚹᚲᛋᛃᛉ" in {
    translator.translateFromLatin("ABCDEFGHIJKLMNOPQRSTUVWXYZ",elderFuthark) shouldEqual "ᚨᛒᚲᛞᛖᚠᚷᚺᛜᛃᚲᛚᛗᚾᛟᛈᚲᚱᛋᛏᚢᚠᚹᚲᛋᛃᛉ"
  }
}
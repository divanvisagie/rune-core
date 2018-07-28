package example


case class Rune(
                 character: String,
                 latinCharacters: String*) {
  def supportsLatin(latin: String): Boolean =
    latinCharacters.contains(latin)


}



trait RuneMap {
  val runes: List[Rune]
}

class ElderFuthark extends RuneMap {
  val runes = List(
    Rune("ᚠ", "F"),
    Rune("ᚢ", "U"),
    Rune("ᛏ", "T"),
    Rune("ᚺ", "H"),
    Rune("ᚨ", "A"),
    Rune("ᚱ", "R"),
    Rune("ᚦ", "TH"),
    Rune("ᚲ", "K", "C"),
    Rune("ᛒ", "B"),


  )
}

class Translator {
  def translateToLatin(text: String, runeMap: RuneMap): String = {
    println("translating " + text)
    text
      .map(x => x.toString)
      .map { character =>
        runeMap.runes.find(_.character equals character) match {
          case Some(r: Rune) => r.latinCharacters.head
          case _ => character
        }
      }.mkString
  }

  def translateFromLatin(text: String, runeMap: RuneMap): String = {

    val sortedRunes = runeMap.runes.sortWith((x,y) => x.latinCharacters.head.length > y.latinCharacters.head.length)
    sortedRunes.foldLeft(text) { (text, rune) =>
      text.replace(
        rune.latinCharacters.head,
        rune.character)
    }


  }

  def sortByLength(s1: String, s2: String) = {
    println("comparing %s and %s".format(s1, s2))
    s1.length > s2.length
  }
}

object Translator {
  def apply(): Translator = new Translator()
}

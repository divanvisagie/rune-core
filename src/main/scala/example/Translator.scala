package example


case class Rune(
                 character: String,
                 latinCharacters: Seq[String]) {
  def supportsLatin(latin: String): Boolean =
    latinCharacters.contains(latin)


}



trait RuneMap {
  val runes: List[Rune]

  implicit def tupleToRune(t: (String, String)): Rune = Rune(t._1, List(t._2))
  implicit def complexTupleToRune(t: (String, Seq[String])): Rune = Rune(t._1, t._2)
}


class ElderFuthark extends RuneMap {

  val runes: List[Rune] = List(
    ("ᚠ", "F"),
    ("ᚢ", "U"),
    ("ᛏ", "T"),
    ("ᚺ", "H"),
    ("ᚨ", "A"),
    ("ᚱ", "R"),
    ("ᚦ", "TH"),
    ("ᚲ", Seq("K", "C")),
    ("ᚷ", "G"),
    ("ᚹ", "W"),
    ("ᛒ", "B")



  )
}

class Translator {
  def translateToLatin(text: String, runeMap: RuneMap): String = {
    runeMap.runes.foldLeft(text) { (text, rune) =>
      rune.latinCharacters.foldLeft(text) { (r, lc) =>
        r.replace(rune.character, lc)
      }
    }
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

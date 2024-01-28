object JurisprudenceSearchFilter extends DocumentSearchFilter {
  private val jurisTypeMappings: Map[String, List[String]] = Map(
    "DECISAO" -> List(
      JurisprudenciaType.DECISAO.name(),
      JurisprudenciaType.DELIMITACAO_DE_DECISAO.name(),
      JurisprudenciaType.DECISAO_DA_PRESIDENCIA.name(),
      JurisprudenciaType.DECISAO_DA_VICE_PRESIDENCIA.name(),
      JurisprudenciaType.DECISAO_DA_CORREGEDORIA.name()
    ),
    "ACORDAO" -> List(
      JurisprudenciaType.ACORDAO.name(),
      JurisprudenciaType.ACORDAO_REPETITIVO.name(),
      JurisprudenciaType.REPERCUSSAO_GERAL.name(),
      JurisprudenciaType.ACORDAO_AFETACAO.name(),
      JurisprudenciaType.INCIDENTE_ASSUNCAO_COMPETENCIA.name()
    ),
    "SUMULA"-> List("SUMULA"),
    "SENTENCA" -> List(
      JurisprudenciaType.SENTENCA.name()
    ),
    "DESPACHO" -> List(
      JurisprudenciaType.DESPACHO.name()
    )
  )

  private def getFilteredTypes(jurisTypes: List[String]): List[String] = {
    jurisTypes.flatMap(jurisTypeMappings.get).flatten
  }

  def degree(degree: Option[JurisprudenciaGrau]): Option[Query] = {
    for (d <- degree) yield {
      termQuery("grau", d)
    }
  }

  def hasDecisionFacts(hasDecisionFacts: Option[Boolean]): Option[Query] = {
    for (h <- hasDecisionFacts) yield {
      termQuery("_possuiEmenta", h)
    }
  }

  def jurisTypes(jurisTypes: List[String]): Option[Query] = {
    getFilteredTypes(jurisTypes) match {
      case Nil => None
      case _ if jurisTypes.contains("TODOS") => None
      case types => Some(termsQuery("_jurisType", types))
    }
  }
}


val types = jurisTypes(List("ACORDAO", "SENTENCA"))
package com.augustoscher

import spray.json._

object CustomModelSummarization {
  // case class ModelHighlight(id: Long, highlight: String, generatedTitle: String)
  case class ModelHighlight(id: Long, highlight: String)

  // implicit val modelHighlight: RootJsonFormat[ModelHighlight] = jsonFormat(
  //   ModelHighlight,
  //   "id",
  //   "formatted_summary"
  //   "formatted_title"
  // )
  implicit val modelHighlight: RootJsonFormat[ModelHighlight] = jsonFormat(
    ModelHighlight,
    "id",
    "formatted_summary"
  )

  def loadMap(): Map[Long, String] = {
    val file = Source.fromFile("src/main/scala/com/augustoscher/summarized_models.json")
    // val lines = file.getLines()
    // val map = lines.map { line =>
    //   val split = line.split("\t")
    //   split(0).toLong -> split(1)
    // }.toMap
    val map = toMap(file.mkString)
    file.close()
    map
  }

  def toMap(content: String): Map[Long, String] = content
    .split("\n")
    .map { line => line.parseJson.convertTo[ModelHighlight] }
    .map(model => model.id -> model.highlight)
    .toMap
}

val summarizationMap: Map[Long, String] = CustomModelSummarization.loadMap()
println(summarizationMap)
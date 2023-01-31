package com.tobe.examples.general

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object CreateDataframe {

  def main(argv: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .getOrCreate()
    val sc = spark.sparkContext

    val data = Seq(
      Row("A", 10, 112233),
      Row("B", 20, 223311),
      Row("C", 30, 331122))

    val schema = StructType(List(
      StructField("name", StringType),
      StructField("age", IntegerType),
      StructField("account", IntegerType)))

    val df = spark.createDataFrame(sc.makeRDD(data), schema)
    df.show()
  }

}

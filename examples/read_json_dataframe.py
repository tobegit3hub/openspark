#!/usr/bin/env python

from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("official_kmeans").getOrCreate()

df = spark.read.json("file:///Users/tobe/code/spark_examples/dataframe_examples/people.json")
df.show()

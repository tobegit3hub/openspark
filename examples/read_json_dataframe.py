#!/usr/bin/env python

from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("official_kmeans").getOrCreate()

df = spark.read.json("file:///examples/people.json")
df.show()

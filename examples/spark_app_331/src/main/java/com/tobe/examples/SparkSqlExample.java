package com.tobe.examples;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkSqlExample {

    public static void main( String[] args ) {
        // Create Spark session
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkSqlExample")
                .master("local")
                .getOrCreate();

        // Create DataFrame
        Encoder<Integer> integerEncoder = Encoders.INT();
        Dataset<Integer> primitiveDS = spark.createDataset(Arrays.asList(1, 2, 3), integerEncoder);
        JavaRDD<Row> rowRDD = primitiveDS.toJavaRDD().map((Function<Integer, Row>) data -> {
            return RowFactory.create(data);
        });

        StructField field = DataTypes.createStructField("value", DataTypes.IntegerType, true);
        List<StructField> fields = new ArrayList<>();
        fields.add(field);
        StructType schema = DataTypes.createStructType(fields);

        Dataset<Row> df = spark.createDataFrame(rowRDD, schema);
        df.show();
        df.registerTempTable("t1");

        // Run SQL
        String sqlText = "SELECT value + 100 FROM t1";
        spark.sql(sqlText).show();
    }

}

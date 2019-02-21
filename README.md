# OpenSpark

## Introduction

The open environment to run any Spark applications.

* Docker image to run in Linux/MacOS/Windows
* Install Hadoop and Spark within one minute
* Submit job to local and remote Yarn clusters
* Repeatable examples of PySpark/Spark streaming/...

## Usage

Run the container.

```
docker run -it -v /:/host tobegit3hub/openspark bash
```

Setup the cluster.

```
/scripts/prepare_sshd.sh
/scripts/prepare_hadoop.sh
```

Run the examples.

```
git clone https://github.com/tobegit3hub/spark_examples
cd ./spark_examples/dataframe_examples/
./create_dataframe_from_memory.sh
```

## Examples

### Run PySpark

```
/examples/read_json_dataframe.py
```

### Submit Yarn Jobs

```
cd ./spark_examples/dataframe_examples/
./create_dataframe_from_memory.sh
```

## Hadoop Cluster

We can use external Hadoop cluster by copying its configuration files in the container.

```bash
cp /host/my_hadoop_conf/* /usr/local/hadoop/etc/hadoop/
```

## Spark Version

OpenSpark have supported multiple Spark versions and you can add more in the docker image.

* spark-1.6.3-bin-hadoop2.6
* spark-2.3.0-bin-hadoop2.7(default)

We can switch the Spark version easily.

```bash
echo $SPARK_HOME

mv /usr/local/spark/ /usr/local/spark_bak/

mv /usr/local/spark-1.6.3-bin-hadoop2.6/ /usr/local/spark/

export PATH=$PATH:$SPARK_HOME/bin
```
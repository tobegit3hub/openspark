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


#!/bin/bash

set -x
set -e

hdfs namenode -format

/usr/local/hadoop/sbin/start-dfs.sh

/usr/local/hadoop/sbin/start-yarn.sh

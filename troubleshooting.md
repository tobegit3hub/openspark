# Trouble Shooting

## Hadoop User

You can change the Hadoop user name by setting the environment.

```bash
export HADOOP_USER_NAME=work
```

## DNS Error

The Hadoop config may access internal server with private domain name. Need to add the DNS config in container.

```bash
vim /etc/resolv.conf

search foo.bar
```

## Java Not Found

The Hadoop config may specify the location of Java binary. If it is different from the default one, we need to link the Java binary.
 

```bash
mkdir -p /usr/local/java/bin/

ln -s /usr/bin/java /usr/local/java/bin/java
```

## ClientConfig Not Found

If you got this error for Spark 2.x, it may be the problem of timeline service.

```
Exception in thread "main" java.lang.NoClassDefFoundError: com/sun/jersey/api/client/config/ClientConfig
        at org.apache.hadoop.yarn.client.api.TimelineClient.createTimelineClient(TimelineClient.java:55)
        at org.apache.hadoop.yarn.client.api.impl.YarnClientImpl.createTimelineClient(YarnClientImpl.java:181)
        at org.apache.hadoop.yarn.client.api.impl.YarnClientImpl.serviceInit(YarnClientImpl.java:168)
        at org.apache.hadoop.service.AbstractService.init(AbstractService.java:163)
        at org.apache.spark.deploy.yarn.Client.submitApplication(Client.scala:151)
        at org.apache.spark.deploy.yarn.Client.run(Client.scala:1146)
        at org.apache.spark.deploy.yarn.YarnClusterApplication.start(Client.scala:1518)
        at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:879)
        at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:197)
        at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:227)
        at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:136)
        at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
Caused by: java.lang.ClassNotFoundException: com.sun.jersey.api.client.config.ClientConfig
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        ... 12 more
```

We can cleared the `yarn-timeline-service.enabled` option in `yarn-site.xml`. Or add the jersey jars in classpath. 

```bash
cp /external_jars/* /usr/local/spark/jars/
```
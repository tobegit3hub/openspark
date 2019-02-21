# Trouble Shooting

## DNS Error

The Hadoop config may access internal server with private domain name. Need to add the DNS config in container.

```bash
vim /etc/resolved.conf

search foo.bar
```

## Java Not Found

The Hadoop config may specify the location of Java binary. If it is different from the default one, we need to link the Java binary.
 

```bash
ln -s /usr/bin/java /usr/local/java/bin/java
```
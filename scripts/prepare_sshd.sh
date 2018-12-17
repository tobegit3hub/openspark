#!/bin/bash

set -x
set -e

ssh-keygen -t rsa -P '' -f /root/.ssh/id_rsa

cat /root/.ssh/id_rsa.pub >> /root/.ssh/authorized_keys

/usr/sbin/sshd -D &

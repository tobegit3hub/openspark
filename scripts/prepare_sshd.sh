#!/bin/bash

set -x
set -e

# Refer to refer to https://docs.docker.com/engine/examples/running_ssh_service/#run-a-test_sshd-container

ssh-keygen -t rsa -P '' -f /root/.ssh/id_rsa

cat /root/.ssh/id_rsa.pub >> /root/.ssh/authorized_keys

/usr/sbin/sshd -D &

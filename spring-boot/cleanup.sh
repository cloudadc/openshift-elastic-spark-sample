#!/usr/bin/sh

oc delete buildconfig spring-boot-s2i
oc delete is spring-boot
oc delete deploymentconfigs spring-boot
oc delete svc spring-boot
oc delete routes spring-boot


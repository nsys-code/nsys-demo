@echo off

SET NSYS_BUNDLE_DIR=%CD%\nsys-demo-bundle\target\nsys-demo

IF EXIST %NSYS_BUNDLE_DIR% GOTO CONTINUE

echo You need to build Nsys Demo at first! Please run command 'build.bat' ... >&2
GOTO EXIT

:CONTINUE
SET DOCKER_OPTS=-p 9160:9160 -v %NSYS_BUNDLE_DIR%:/opt/nsys-demo

docker run -it --rm %DOCKER_OPTS% nsys/nsys-demo /opt/nsys-demo/bin/nsys-container.sh run %*

:EXIT
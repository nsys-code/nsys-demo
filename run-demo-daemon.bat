@echo off

SET NSYS_BUNDLE_DIR=%CD%\nsys-demo-bundle\target\nsys-demo

IF EXIST %NSYS_BUNDLE_DIR% GOTO CONTINUE

echo You need to build Nsys Demo at first! Please run command 'build.bat' ... >&2
GOTO EXIT

:CONTINUE
%NSYS_BUNDLE_DIR%\bin\nsys-launcher.bat nsys-daemon run

:EXIT
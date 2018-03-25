#!/bin/bash

##########################################################################
#                                                                        #
# Nsys Demo Docker Library                                               #
# Copyright 2015, 2018 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>  #
# All rights reserved.                                                   #
#                                                                        #
# Web: code.nsys.org                                                     #
# Git: github.com/nsys-code/nsys-demo                                    #
#                                                                        #
##########################################################################

DOCKER_IMAGE_NAME=nsys/nsys-demo-node
DOCKER_IMAGE_TAG=1.0.0
DOCKERCTL_SCRIPT=docker-ctl.sh
DOCKERCTL_SCRIPT_URL=https://raw.githubusercontent.com/nsys-code/nsys-docker-library/master/scripts/$DOCKERCTL_SCRIPT
DOCKERCTL_CMD="$( cd "$(dirname "$0")" ; pwd -P )/$DOCKERCTL_SCRIPT"

if [ ! -e $DOCKERCTL_SCRIPT ]; then
    echo
    echo "Downloading Docker Control Script from '$DOCKERCTL_SCRIPT_URL'..."
    echo
    
    curl -o $DOCKERCTL_SCRIPT $DOCKERCTL_SCRIPT_URL
    chmod a+x $DOCKERCTL_SCRIPT
fi

echo
echo "Running application:		$DOCKERCTL_CMD"
echo "Docker image name:		$DOCKER_IMAGE_NAME"

cp `pwd`/../scripts/nsys-demo-installer.sh ./
cp `pwd`/../../nsys-demo-bundle/target/nsys-demo-bundle-1.0.0.0.zip ./nsys-demo-bundle.zip

$DOCKERCTL_CMD build $DOCKER_IMAGE_NAME

rm nsys-demo-installer.sh
rm nsys-demo-bundle.zip

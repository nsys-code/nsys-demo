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

NSYS_INST_SCRIPT=nsys-demo-installer.sh
NSYS_BUNDLE_FILE=nsys-demo-bundle.zip
NSYS_BUNDLE_PATH=/tmp/$NSYS_BUNDLE_FILE

echo
echo "Downloading '$NSYS_INST_SCRIPT' script..."
echo

chmod a+x $NSYS_INST_SCRIPT
./$NSYS_INST_SCRIPT

if [ -e $NSYS_BUNDLE_PATH ]; then
    echo "Removing file '$NSYS_BUNDLE_PATH' with Nsys Demo bundle..."
    echo
    rm $NSYS_BUNDLE_PATH
fi

exit $?

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

echo
echo "Starting up Nsys Demo Node..."
echo

NSYS_DAEMON_SCRIPT=/etc/init.d/nsys-demo-daemon

if [ ! -e $NSYS_DAEMON_SCRIPT ]; then
    echo "Unable to find '$NSYS_DAEMON_SCRIPT'! Fatal error! Terminating script..."
    echo
    exit 1
fi

$NSYS_DAEMON_SCRIPT run

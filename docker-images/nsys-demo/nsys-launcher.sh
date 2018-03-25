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
echo "Starting up Nsys Demo Portal..."
echo

NSYS_PORTAL_SCRIPT=/etc/init.d/nsys-demo-portal

if [ ! -e $NSYS_PORTAL_SCRIPT ]; then
    echo "Unable to find '$NSYS_PORTAL_SCRIPT'! Fatal error! Terminating script..."
    echo
    exit 1
fi

$NSYS_PORTAL_SCRIPT run

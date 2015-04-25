#!/bin/bash

NSYS_BUNDLE_DIR=`pwd`/nsys-demo-bundle/target/nsys-demo

if [[ ! -d "$NSYS_BUNDLE_DIR" ]]; then
    echo "You need to build Nsys Platform at first! Please run command 'build.sh' ..." >&2
    exit 1	
fi

chmod -R 755 $NSYS_BUNDLE_DIR/bin/*.sh
sh $NSYS_BUNDLE_DIR/bin/nsys-launcher.sh nsys-daemon run
#!/bin/sh

# docker is busted
#exec docker run --rm -v $(PWD):/workdir `docker build -q .` -I /usr/include --output /workdir/src/main/java $@
exec /Users/jtyuzawa/Downloads/jextract-master/build/jextract/bin/jextract -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include --output src/main/java $@
#!/bin/sh
rm -f include/AR/config.h

if [ "$ACTION" != "clean" ]
then

SEDTMP=/tmp/SED.$$
trap "rm -f $SEDTMP; exit 0" 0 1 2 3 15
VERSION=`sed -En -e 's/.*AR_HEADER_VERSION_STRING[[:space:]]+"([0-9]+\.[0-9]+(\.[0-9]+)*)".*/\1/p' include/AR/config.h.in`

cat > $SEDTMP <<EOF
s/@CC@/$CC/
s/@CPP@/$CPP/
s/@CFLAG@/$CFLAG/
s/@LDFLAG@/$LDFLAG/
s/@ARFLAG@/$ARFLAG/
s/@RANLIB@/$RANLIB/
s/@LIBS@/$LIBS/
s/@CV_CFLAG@/$CV_CFLAG/
s/@CV_LDFLAG@/$CV_LDFLAG/
s/@VERSION@/$VERSION/
EOF

echo "  create share/artoolkit5-config"
sed -f $SEDTMP <share/artoolkit5-config.in > share/artoolkit5-config
chmod ugo+rx share/artoolkit5-config

echo "  create include/AR/config.h"
sed -f $SEDTMP <include/AR/config.h.in > include/AR/config.h

echo "  update Xcode/version.xcconfig"
sed -i "" -e "s/VERSION = \".*\"/VERSION = \"$VERSION\"/" Xcode/version.xcconfig

echo "Done."

fi


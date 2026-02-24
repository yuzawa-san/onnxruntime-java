#!/bin/sh

OLD_VERSION=$(cat ORT_VERSION)
NEW_VERSION=$(curl -s https://api.github.com/repos/microsoft/onnxruntime/tags | jq -r ".[0].name" | sed 's/^v//g')
echo "old: $OLD_VERSION"
echo "new: $NEW_VERSION"
if [ "$OLD_VERSION" = "$NEW_VERSION" ]; then
  echo "::notice::up to date"
  exit 0
fi
BRANCH=orttesting/$NEW_VERSION
git checkout -b $BRANCH
if [ $? -ne 0 ]; then
   echo "::notice::branch $BRANCH already exists"
   exit 0
fi

echo $NEW_VERSION > ORT_VERSION
git commit -am "ORT v$NEW_VERSION bump"
#git push origin $BRANCH
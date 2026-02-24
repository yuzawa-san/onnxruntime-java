#!/bin/sh

OLD_VERSION=$(cat ORT_VERSION)
NEW_VERSION=$(curl -s https://api.github.com/repos/microsoft/onnxruntime/tags | jq -r ".[0].name" | sed 's/^v//g')
echo "old: $OLD_VERSION"
echo "new: $NEW_VERSION"
BRANCH=orttesting/$NEW_VERSION
git checkout -b $BRANCH
if [ $? -ne 0 ]; then
   echo "branch already exists"
   exit 1
fi

git config --global user.name "github-actions[bot]"
git config --global user.email "41898282+github-actions[bot]@users.noreply.github.com"

echo -n $NEW_VERSION > ORT_VERSION
git commit -am "ORT v$NEW_VERSION bump"
git push origin $BRANCH
FROM openjdk:17-slim-bullseye
# TODO: something weird is going on with stdint.h
# TODO: gradle does not support java 19 yet, so we need 17 for now

RUN apt-get update && apt-get install -y -q \
	lsb-release wget software-properties-common gnupg

ADD https://apt.llvm.org/llvm.sh . 
RUN chmod +x llvm.sh && \
	./llvm.sh 14 all && \
	ln -s /usr/lib/llvm-14/lib/clang/14.*/include /usr/lib/llvm-14/lib/clang/14/include && \
	apt-get clean

ADD https://download.java.net/java/early_access/jdk19/32/GPL/openjdk-19-ea+32_linux-x64_bin.tar.gz .
RUN tar xvzf openjdk-19-ea+32_linux-x64_bin.tar.gz

ARG JEXTRACT_REVISION=0582eaf1b4cdba95f0ee8c2480767433bb647d0d
ADD https://github.com/openjdk/jextract/archive/$JEXTRACT_REVISION.tar.gz .
RUN tar xvzf $JEXTRACT_REVISION.tar.gz && mv jextract-$JEXTRACT_REVISION jextract
RUN cd /jextract && sh ./gradlew -Pjdk19_home=/jdk-19 -Pllvm_home=/usr/lib/llvm-14 verify

ENTRYPOINT ["/jextract/build/jextract/bin/jextract"]
CMD ["/bin/bash"]
WORKDIR /workdir
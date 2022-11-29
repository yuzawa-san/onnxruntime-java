FROM --platform=linux/amd64 debian:bullseye-slim

RUN apt-get update && apt-get install -y -q \
  libc-dev \
&& apt-get clean

ADD https://download.java.net/java/early_access/jextract/2/openjdk-19-jextract+2-3_linux-x64_bin.tar.gz .
RUN tar xvzf openjdk-19-jextract+2-3_linux-x64_bin.tar.gz
ENTRYPOINT ["/jextract-19/bin/jextract"]
CMD ["/bin/bash"]
WORKDIR /workdir